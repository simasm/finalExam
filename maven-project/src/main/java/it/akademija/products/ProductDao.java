package it.akademija.products;

import java.util.List;

public interface ProductDao {
	
	List<Product> getProducts(); 
	void addProduct(Product product);
	boolean deleteProduct(long id);
	
}
