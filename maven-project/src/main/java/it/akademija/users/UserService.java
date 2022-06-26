package it.akademija.users;

 import java.util.List;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Lazy;
 import org.springframework.security.core.authority.AuthorityUtils;
 import org.springframework.security.core.session.SessionInformation;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.security.crypto.factory.PasswordEncoderFactories;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 import org.springframework.security.core.session.SessionRegistry;

@Service
public class UserService implements UserDetailsService{
	 
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	@Lazy
	private SessionRegistry sessionRegistry;
	
	@Autowired
	private PasswordEncoder encoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userRepo.findByUserName(username);
		if (user == null) 
			throw new UsernameNotFoundException(username + " not found");
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(),
				AuthorityUtils.createAuthorityList(
						new String[] { "ROLE_"+user.getRole().name() } ));
			
	} 
	
	@Transactional
	public void createUser(String username, String password,Role role) {
		
		if(userRepo.findByUserName(username)!= null)
			return;
		
		Users newUser = new Users();
		newUser.setRole(role);
		newUser.setUserName(username);
	     
		newUser.setPassword(encoder.encode(password));
		userRepo.saveAndFlush(newUser);
		
	}
	
	@Transactional
	public void createUser(String username, String password) {
		
		if(userRepo.findByUserName(username)!= null)
			return;
		
		Users newUser = new Users();
		newUser.setRole(Role.USER);
		newUser.setUserName(username);
	     
		newUser.setPassword(encoder.encode(password));
		userRepo.saveAndFlush(newUser);
		
	}
	

	
	@Transactional(readOnly = true)
	public Users findByUserName(String username) {
		return userRepo.findByUserName(username); 
	}
	
	
	@Transactional
	public void deleteUser(String username) {
		Users user = userRepo.findByUserName(username);
		
		expireSession(user);
		userRepo.deleteByUserName(username);
	}
	
	private void expireSession(Users user) {

		List<Object> principals = sessionRegistry.getAllPrincipals();
		for (Object principal : principals) {
			UserDetails pUser = (UserDetails) principal;
			if (pUser.getUsername().equals(user.getUserName())) {
				for (SessionInformation activeSession : sessionRegistry.getAllSessions(principal, false)) {
					activeSession.expireNow();
				}
			}
		}
	}
}
