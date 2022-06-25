package it.akademija.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class User {
	
	@Column
	private String username;
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dbid;
	
	public User() { }
	public User(String username ) {
		this.username = username;
	}
 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
 
}
