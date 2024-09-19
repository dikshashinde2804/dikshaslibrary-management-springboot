package in.techdenovo.dikshaapps.library_management_springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.model.Category;
import in.techdenovo.dikshaapps.library_management_springboot.service.CategoryService;



@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
    CategoryService categoryService;
	
	@GetMapping("/add")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		
		return "addCategory";
			          
	}
	
	@PostMapping("/add")
	public String addCategory(@ModelAttribute("category") Category category) {
//		System.out.println(category.getCategoryName() + " " + category.getCategoryDescription());
	categoryService.addCategory(category);
	return "redirect:/category/list";
	}
	
	@GetMapping("/list")
		public String allCategory(Model model) {
		List<Category> category = new ArrayList<>();
		category= categoryService.allCategories();
		model.addAttribute("categories", category);
		return "listcategory";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id,Model model) {
		categoryService.deleteCategory(id);
		return "redirect:/category/list";
	}
	@GetMapping("/update/{id}")
	public String updateCategory(@PathVariable("id") int id,Model model) {
		Category existingCategory = categoryService.findCategory(id);
		model.addAttribute("category", existingCategory);
		return "editcategory";
	}
	@PostMapping("/update")
	public String updateCategory(@ModelAttribute("category") Category category) {
		categoryService.updateCategory(category);
		return "redirect:/category/list";
	}
	

}
