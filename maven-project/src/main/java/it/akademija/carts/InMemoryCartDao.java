package it.akademija.carts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCartDao implements CartDao {

	private final Map<String, List<Long>> carts = new ConcurrentHashMap<>();

	@Override
	public Map<String, List<Long>> getCarts() {

		return Collections.unmodifiableMap(carts);
	}

	@Override
	public void addCart(String username, List<Long> cart) {
		carts.put(username, cart);

	}

	@Override
	public void removeCart(String username) {
		carts.remove(username);

	}

	@Override
	public List<Long> getCart(String username) {
		 if(carts.get(username)==null)
			 return new ArrayList<>();
		return carts.get(username);
	}

}
