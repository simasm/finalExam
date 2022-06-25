package it.akademija;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import it.akademija.users.CreateUserCommand;
import it.akademija.users.User;

import java.util.List;

 
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = 
SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = {App.class})  
public class UserControllerIntTest {
	
	private static final String URI = "/api/users";
	@Autowired 
	private TestRestTemplate rest;
	
	@Test
	public void createsUserThenRetrievesUserListAndDeletesUser() {
		final String username = "testUsername3";
		final CreateUserCommand createUser = new CreateUserCommand();
		rest.delete(URI + "/" + username);
		int size1 = rest.getForEntity(URI,  List.class ).getBody().size();
		createUser.setUsername(username);
		rest.postForLocation(URI, createUser);
		int size2 = rest.getForEntity(URI,  List.class ).getBody().size();
		rest.delete(URI + "/" + username);
		int size3 = rest.getForEntity(URI, List.class).getBody().size();
	//	System.out.println("size2 " +size2);
 
		MatcherAssert.assertThat(size2, CoreMatchers.is(size1+1));
	 
		
	//	System.out.println("size3 " +size3);

		MatcherAssert.assertThat(size3, CoreMatchers.is(size1));
	}
 
	 
	
}
