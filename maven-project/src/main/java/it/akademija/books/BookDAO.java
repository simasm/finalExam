package it.akademija.books;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.category.Category;

public interface BookDAO extends JpaRepository<Book, Long> {

	List<Book> findAll();
	void deleteBookById(Long id);
	List<Book> findByName(String name);
	Book findByIsbn(String isbn);
	List<Book> findByCategoryName(String name);
	
}
