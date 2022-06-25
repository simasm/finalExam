package it.akademija.products;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
public class ProdList {
	@Autowired
    private List<Product> prodlist;
    
    public ProdList() { }
    
	public List<Product> getProdlist() {
		return this.prodlist;
	}
	
	public void setProdlist(List<Product> list) {
		this.prodlist = list;
	}


}
