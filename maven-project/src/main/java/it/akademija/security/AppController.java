package it.akademija.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.users.UserRepo;
import it.akademija.users.Users;

 
 
	@RestController
	public class AppController {

		@Autowired
		private UserRepo userRepo;
		
		@GetMapping("/api/loggedUser")
		public ResponseEntity<String> getLoggedUser() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			if(!(authentication instanceof AnonymousAuthenticationToken)) {
				String username = authentication.getName();
				 Users user = userRepo.findByUserName(username);
				return new ResponseEntity<String>  (user.getUserName() +"+"+ user.getRole().name(), HttpStatus.OK);
			
		
			
			}
		
			return new ResponseEntity<String>("unauthorized", HttpStatus.UNAUTHORIZED);
			
		
		
		}
}
