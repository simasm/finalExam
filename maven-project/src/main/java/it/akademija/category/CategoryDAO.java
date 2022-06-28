package it.akademija.category;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Long> {

	List<Category> findAll() ;
	void deleteByName(String name);
	Category findByName(String name);
}
