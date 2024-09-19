package in.techdenovo.dikshaapps.library_management_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.model.Category;
import in.techdenovo.dikshaapps.library_management_springboot.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
	
		return categoryRepository.save(category);
		
	}
	 public List<Category> allCategories() {
			
			return categoryRepository.findAll();
		}

	 public void deleteCategory(int id) {
			
			Category existingCategory = categoryRepository.findById(id).orElse(null);
			if(existingCategory!=null) {
				categoryRepository.delete(existingCategory);
			}
		}
		public Category findCategory(int id) {
			return categoryRepository.findById(id).orElse(null);
		}
		public Category updateCategory(Category category) {
			Category existingCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);
			if(existingCategory!=null) {
				existingCategory.setCategoryName(category.getCategoryName());
				existingCategory.setCategoryDescription(category.getCategoryDescription());
			}
			return categoryRepository.save(existingCategory);
			
		}
}
