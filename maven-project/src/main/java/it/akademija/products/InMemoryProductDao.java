package it.akademija.products;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductDao implements ProductDao {
	
	private final List<Product> products = new CopyOnWriteArrayList<>();

	@Override
	public List<Product> getProducts() {
		 
		return Collections.unmodifiableList(products);
	}

	@Override
	public void addProduct(Product product) {
		products.add(product);
		
	}
 
	@Override
	public boolean deleteProduct(long id) {
	 
		return products.remove(products.stream()
				.filter(product -> product.getId() == id)
				.findFirst().orElse(null));
	}

}
