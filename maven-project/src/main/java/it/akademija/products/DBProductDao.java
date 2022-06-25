package it.akademija.products;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DBProductDao implements ProductDao {

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Autowired PagingData pagingData;
	
	@Override
	public List<Product> getProducts() {
		
		return entityManager.createQuery("SELECT p from Product p",
				Product.class).setMaxResults(pagingData.getLimit())
				.getResultList();
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
		
	}

	@Override
	public boolean deleteProduct(long id) {
		Product product = entityManager
				.createQuery("SELECT p from Product p where id = :pn",
						Product.class)
				.setParameter("pn", id).getSingleResult();
		if(entityManager.contains(product)) {
			entityManager.remove(product);
			return true;
			}
		else {
			entityManager.remove(entityManager.merge(product)); 
			return false;
		}
				
	}

}
