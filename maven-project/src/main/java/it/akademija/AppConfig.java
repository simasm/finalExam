package it.akademija;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
 
import it.akademija.users.UserRepository;
import it.akademija.users.UserService;

@ImportResource({"classpath*:application-context.xml"})
@Configuration
public class AppConfig {
	 
  

	
	@Bean
 	PasswordEncoder encoder() {
 		return   PasswordEncoderFactories.createDelegatingPasswordEncoder();
 	}
  
	 
}