package it.akademija.reservation;

import java.util.List;
import java.util.Map;

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
 @Api(tags="reservation-servisas")
@RequestMapping(value = "api/reservation")
public class ReservationController {

	private final CartDao cartDao;
	
	@Autowired
	public ReservationController(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
 	@RequestMapping(method = RequestMethod.GET)
 	@ApiOperation(value="Get users", notes="Returns existing carts")
	public Map<String, List<Long>> getCarts() {
		return cartDao.getCarts();
	}
	
 	@RequestMapping(method = RequestMethod.POST)
 	@ApiOperation(value="Create cart for user", notes="Creates new cart")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCart(@ApiParam(value="Create cart for user",required=true)
			@RequestBody final CreateCartCommand cmd ) {
		System.out.println(cmd.getCart());
		 cartDao.addCart(cmd.getUsername(), cmd.getCart());
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{username}")
	@ApiOperation(value="Get user's cart",notes="Gets cart by username")
	public List<Long> getUserCart(@PathVariable final String username) {
		System.out.println(username + " requested cart");
		return cartDao.getCart(username);
	}
}
