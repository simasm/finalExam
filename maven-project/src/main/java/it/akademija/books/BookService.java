package it.akademija.books;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.akademija.category.Category;
import it.akademija.category.CategoryDTO;
import it.akademija.category.CategoryService;

@Service
public class BookService {

	@Autowired
	BookDAO bookDAO;

	@Autowired
	CategoryService categoryService;

	@Transactional
	public boolean addBook(BookDTO dto) {

		var categoryDTO = new CategoryDTO(dto.getCategoryName());
		var category = categoryService.findCategoryByName(categoryDTO.getName());
		if (category == null)
			categoryService.addCategory(categoryDTO.getName());
		

		Book book = new Book(dto.getName(),category, dto.getDescription(), dto.getPages(),
				dto.getIsbn(), null);

		return bookDAO.saveAndFlush(book) != null;

	}

	@Transactional
	public boolean deleteBookById(Long id) {
		if (findById(id) != null) {
			bookDAO.deleteBookById(id);
			return true;
		}
		return false;
	}

	public List<BookDTO> findByCategory(String name) {
		var category = categoryService.findCategoryByName(name);
		if (category != null) {
		 var books =  bookDAO.findByCategoryName(category.getName());
		  List<BookDTO> response = new ArrayList<BookDTO>();
			for (var b : books) {
				response.add(entityToDTO(b));
			}
			return response;
		}
		return new ArrayList<BookDTO>();
	}
	
	public Book findById(Long id) {
		return bookDAO.findById(id).orElse(null);
	}

	public List<BookDTO> findByName(String name) {

		var books = bookDAO.findByName(name);
		List<BookDTO> response = new ArrayList<BookDTO>();
		for (var b : books) {
			response.add(entityToDTO(b));
		}
		return response;
	}

	public List<BookDTO> findAllBooks() {
		var books = bookDAO.findAll();
		List<BookDTO> response = new ArrayList<BookDTO>();
		for (var b : books) {
			response.add(entityToDTO(b));
		}

		return response;
	}

	public BookDTO entityToDTO(Book entity) {
		var id = entity.getId();
		var name =entity.getName();
				var cat =  entity.getCategory();
				var cname = "";
				if (cat != null)
					cname = cat.getName();
				var desc =entity.getDescription() ;
				var pages = entity.getPages();
				var isbn = entity.getIsbn();
		return new BookDTO(id, name,cname,desc,pages,isbn,null);
			 
	}

}
