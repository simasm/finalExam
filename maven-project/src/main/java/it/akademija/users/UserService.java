package it.akademija.users;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDao{
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void createUser(User user) {
		if (user != null)
			if (userRepository.findByUsername(user.getUsername()) == null) {
				userRepository.save(user);
			}

	}

	@Override
	public boolean deleteUser(String username) {

		if (userRepository.findByUsername(username) != null) {
			userRepository.delete(userRepository.findByUsername(username));
			return true;
		} else
			return false;

	}

}
