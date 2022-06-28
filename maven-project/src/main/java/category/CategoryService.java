package category;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional
	public boolean addCategory(CategoryDTO dto) {

		return categoryDAO.saveAndFlush(new Category(dto.getName())) != null;

	}

	@Transactional
	public boolean deleteCategoryByName(CategoryDTO dto) {

		categoryDAO.deleteByName(dto.getName());
		return true;
	}

	public CategoryDTO getCategoryByName(CategoryDTO dto) {

		return new CategoryDTO(categoryDAO.findByName(dto.getName()).getName());
	}

}
