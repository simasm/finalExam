package it.akademija.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="product service")
@RequestMapping(value = "api/products")
public class ProductController {

	private final ProductService productService;
	
	@Autowired PagingData pagingData;
	
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	
 	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="get products")
 	public List<Product> getProducts() {
 		pagingData.setLimit(5);
		return productService.getProducts();
	}
	
	@ApiOperation(value="create product")
 	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@ApiParam(value="product data")
			@RequestBody final CreateProductCommand cmd ) {
		productService.createProduct(new Product(
				cmd.getTitle(),
				cmd.getQuantity(),
				cmd.getPrice()));
		System.out.println("created "+ cmd.getTitle());
	}
	
	@ApiOperation(value="delete product by id")
 	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public void deleteUser(@ApiParam(value="product id")
			 @PathVariable final long id) {
		
		 System.out.println("Deleted: " + id + 
				 " " +  productService.deleteProduct(id));
	 }
}
