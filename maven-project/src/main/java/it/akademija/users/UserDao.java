package it.akademija.users;

import java.util.List;

public interface UserDao {
	List<User> getUsers();
	void createUser(User user);
	
	boolean deleteUser(String username);
}
