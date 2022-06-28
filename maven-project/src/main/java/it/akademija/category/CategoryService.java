package it.akademija.category;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional
	public Category addCategory(String name) {

		var c = new Category(name);
		return categoryDAO.saveAndFlush(c) ;

	}

	@Transactional
	public void deleteCategoryByName(String name) {

		categoryDAO.deleteByName(name);
		 
	}

	public Category findCategoryByName(String name) {

		return categoryDAO.findByName(name); 
	 
	}
	
	public List<CategoryDTO> findAllCategories() {
		var categories = categoryDAO.findAll();
		List<CategoryDTO> response = new ArrayList<CategoryDTO>();
		for(var c : categories) {
			response.add(new CategoryDTO(c.getName()));
		}
		
		return response;
	}

}
