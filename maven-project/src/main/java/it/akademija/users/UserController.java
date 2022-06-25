package it.akademija.users;

 import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="user-service")
@RequestMapping(value="api/users")
public class UserController {

	private final UserDao userService;
	
	@Autowired
	public UserController(UserDao userService) {
		this.userService = userService;
	}
	
	@ApiOperation(value="get users")
 	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
	 
		return userService.getUsers();
	
	}
	
	@ApiOperation(value="create new user")
 	@RequestMapping(method = RequestMethod.POST) 
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(
			@ApiParam(value="User data")
			@Valid
			@RequestBody 
			final CreateUserCommand cmd) {
		int size = userService.getUsers().size();
		userService.createUser(new User(cmd.getUsername() 
	 
									));
 		if(size < userService.getUsers().size())
 			System.out.println("created " + cmd.getUsername());
	}
	
	@ApiOperation(value="delete user")
 	@RequestMapping(method = RequestMethod.DELETE, path = "/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void deleteUser(@ApiParam(value="username to be deleted")
			 @PathVariable final String username) {
		
		 System.out.println("Deleted: " + username +
				 " " +  userService.deleteUser(username));
	 }
}
