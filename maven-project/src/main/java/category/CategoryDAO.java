package category;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Long> {

	Set<Category> findAllCategories() ;
	void deleteByName(String name);
	Category findByName(String name);
}
