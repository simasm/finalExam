package it.akademija.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.category.CategoryDTO;
import it.akademija.category.CategoryService;

@RestController
@Api(tags = "book-servisas")
@RequestMapping(value = "/api/book")
public class BookController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ApiOperation(value = "Create new book")
	@ResponseBody
	public ResponseEntity<String> createNewBook(@ApiParam @RequestBody BookDTO dto) {

		if (bookService.addBook(dto)) {

			return new ResponseEntity<String>("Knyga sukurta", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Sukurti nepavyko", HttpStatus.BAD_REQUEST);
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete book")
	@ResponseBody
	public ResponseEntity<String> deleteBookById(@PathVariable Long id) {

		if (bookService.deleteBookById(id))
			return new ResponseEntity<String>("Istrinta", HttpStatus.OK);

		return new ResponseEntity<String>("Istrinti nepavyko", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	@ApiOperation(value = "Find by name")
	@ResponseBody
	public ResponseEntity<List<BookDTO>> findBookByName(@PathVariable String name) {

		var books = bookService.findByName(name);
		if (books != null) {
			return new ResponseEntity<List<BookDTO>>(books, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	@ApiOperation(value = "Find books")
	@ResponseBody
	public ResponseEntity<List<BookDTO>> findAllBooks() {

		List<BookDTO> response = bookService.findAllBooks();
		if (response != null) {
			return new ResponseEntity<List<BookDTO>>(response, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/findcategory/{name}", method = RequestMethod.GET)
	@ApiOperation(value = "Find books by category")
	@ResponseBody
	public ResponseEntity<List<BookDTO>> findByCategory(String name) {

		List<BookDTO> response = bookService.findByCategory(name);
		if (response != null) {
			return new ResponseEntity<List<BookDTO>>(response, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	

}
