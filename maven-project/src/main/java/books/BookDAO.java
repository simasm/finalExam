package books;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {

	List<Book> findAllBooks();
	boolean deleteBookById(Long id);
	
	
}
