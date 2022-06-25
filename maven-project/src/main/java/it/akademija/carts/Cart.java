package it.akademija.carts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Cart {
  
	@Autowired
    private List<Long> items;
    
    
    
    public Cart( ) {
    	super();
    	 
    }
    
 
    
    public List<Long> getItems() {
    	return this.items;
    }
    
    public void setItems(List<Long> items) {
    	this.items = items;
    }
    

    
}
