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

import in.techdenovo.dikshaapps.library_management_springboot.model.Author;

import in.techdenovo.dikshaapps.library_management_springboot.service.AuthorService;



@Controller
@RequestMapping("author")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/add")
	public String addAuthor(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "addAuthor";
		
	}
	@PostMapping("/add")
	public String addAuthor(@ModelAttribute Author author) {
			authorService.addAuthor(author);
		return "redirect:/author/list";
	}
	
	@GetMapping("/list")
	public String allAuthor(Model model) {
		List<Author> authors = new ArrayList<>();
		authors= authorService.allAuthors();
		model.addAttribute("authors", authors);
		return "listauthor";
	}
	@GetMapping("/delete/{id}")
	public String deleteAuthor(@PathVariable int id,Model model) {
		authorService.deleteAuthor(id);
		return "redirect:/author/list";
	}
	@GetMapping("/update/{id}")
	public String updateAuthor(@PathVariable int id,Model model) {
		Author existingAuthor = authorService.findAuthor(id);
		model.addAttribute("author", existingAuthor);
		return "editauthor";
	}
	@PostMapping("/update")
	public String updateAuthor(@ModelAttribute Author author) {
		authorService.updateAuthor(author);
		return "redirect:/author/list";
	}
}
