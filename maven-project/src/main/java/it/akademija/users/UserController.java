package it.akademija.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "user-service")
@RequestMapping(value = "api/users")
public class UserController {
 
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(path="/user/create",method =  RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createUser(String userName, String password) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(userService.findByUserName(username)!=null)
			return new ResponseEntity<String>("Naudotojas egzistuoja", HttpStatus.BAD_REQUEST);
		
		userService.createUser(userName, password);
		
		return new ResponseEntity<String>("Sukurtas naudotojas",HttpStatus.CREATED);
		
	}
 
}
