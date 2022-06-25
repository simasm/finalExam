package it.akademija.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	@Autowired @Qualifier ("repoProductDao")
	private ProductDao productDao;
	
	
	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	
	@Transactional
	public void createProduct(Product product) {
		productDao.addProduct(product);
	}
	
	@Transactional
	public boolean deleteProduct(Long id) {
		return productDao.deleteProduct(id);
	}
}
