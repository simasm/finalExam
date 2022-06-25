package it.akademija.users;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

//@Repository
public class InMemoryUserDao implements UserDao {

	private final List<User> users = new CopyOnWriteArrayList<>();
	
	@Override
	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}

	
	@Override
	public void createUser(User user) {
		if(user != null)
			if(!users.stream()
				.anyMatch(usr -> usr.getUsername()
						.equals(user.getUsername())))
			users.add(user);
		
	}

	@Override
	public boolean deleteUser(String username) {
		 
		return users.remove(users.stream()
				.filter(user -> user.getUsername()
									.equals(username))
				.findFirst().orElse(null));
		
	}

}
