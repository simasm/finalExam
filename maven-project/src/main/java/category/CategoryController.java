package category;

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

@RestController
@Api(tags = "Category")
@RequestMapping(value = "api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/category/new", method = RequestMethod.POST)
	@ApiOperation(value = "Create new category")
	@ResponseBody
	public ResponseEntity<String> createNewCategory(@ApiParam @RequestBody CategoryDTO dto) {

		if (categoryService.findCategoryByName(dto) == null) {
			categoryService.addCategory(dto);
			return new ResponseEntity<String>("Kategorija sukurta", HttpStatus.OK);
		}

		return new ResponseEntity<String>("Sukurti nepavyko", HttpStatus.BAD_REQUEST);
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/category/delete/{name}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete category")
	@ResponseBody
	public ResponseEntity<String> deleteCategory(@PathVariable String name) {

		if (categoryService.findCategoryByName(new CategoryDTO(name)) != null) {
			categoryService.deleteCategoryByName(new CategoryDTO(name));
			return new ResponseEntity<String>("Istrinta", HttpStatus.OK);

		}

		return new ResponseEntity<String>("Istrinti nepavyko", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/category/find", method = RequestMethod.GET)
	@ApiOperation(value = "Find category")
	@ResponseBody
	public ResponseEntity<CategoryDTO> findCategory(@ApiParam @RequestBody CategoryDTO dto) {

		var categoryDTO = categoryService.findCategoryByName(dto);
		if (categoryDTO != null) {

			return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
