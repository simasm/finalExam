package it.akademija;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import it.akademija.products.DBProductDao;
import it.akademija.products.ProductDao;
import it.akademija.users.UserRepository;

@ImportResource({"classpath*:application-context.xml"})
@Configuration
public class AppConfig {
	 
 
 	@Bean
 	@Qualifier ("repoProductDao")
 	ProductDao productDao() {
 		return new DBProductDao();
 	}
	

	
	
 
	 
}