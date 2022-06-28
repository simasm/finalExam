package it.akademija.category;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.books.BookService;

@RestController
@Api(tags = "category-servisas", description = "category servisas")
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ApiOperation(value = "Create new category")
	@ResponseBody
	public ResponseEntity<String> createNewCategory(@ApiParam @RequestBody String name) {

		if (categoryService.findCategoryByName(name) == null) {
			categoryService.addCategory(name);
			return new ResponseEntity<String>("Kategorija sukurta", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Sukurti nepavyko", HttpStatus.BAD_REQUEST);
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete category")
	@ResponseBody
	public ResponseEntity<String> deleteCategory(@PathVariable String name) {

		if (bookService.findByCategory(name).size() == 0 && categoryService.findCategoryByName(name) != null) {
			categoryService.deleteCategoryByName(name);
			return new ResponseEntity<String>("Istrinta", HttpStatus.OK);

		}

		return new ResponseEntity<String>("Istrinti nepavyko", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	@ApiOperation(value = "Find category")
	@ResponseBody
	public ResponseEntity<CategoryDTO> findCategory(@PathVariable String name) {

		var categoryDTO = new CategoryDTO(name);
		var category = categoryService.findCategoryByName(name);
		if (category != null) {

			return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	@ApiOperation(value = "Find category")
	@ResponseBody
	public ResponseEntity<List<CategoryDTO>> findAllCategories() {

		List<CategoryDTO> response = categoryService.findAllCategories();
		if (response != null) {
			return new ResponseEntity<List<CategoryDTO>>(response, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
