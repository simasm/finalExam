package it.akademija.reservation;

import java.util.List;

public class CreateCartCommand {

	private String username;
	private List<Long> cart;
 
	public List<Long> getCart() {
		return cart;
	}

	public void setCart(List<Long> cart) {
		this.cart = cart;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
