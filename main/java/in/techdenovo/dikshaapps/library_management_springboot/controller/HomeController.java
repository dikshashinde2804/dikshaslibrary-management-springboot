package in.techdenovo.dikshaapps.library_management_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.techdenovo.dikshaapps.library_management_springboot.repository.AuthorRepository;
import in.techdenovo.dikshaapps.library_management_springboot.repository.StudentRepository;
import in.techdenovo.dikshaapps.library_management_springboot.service.AuthorService;
import in.techdenovo.dikshaapps.library_management_springboot.service.BookService;
import in.techdenovo.dikshaapps.library_management_springboot.service.StudentService;

@Controller
@RequestMapping("dashboard")
public class HomeController {
	@Autowired
	BookService bookService;
	@Autowired
    AuthorService authorService;
	@Autowired
    StudentService studentService;
	
	@GetMapping("/")
	public String displayData(Model model) {
		model.addAttribute("booksCount", bookService.countBooks());
		model.addAttribute("authorsCount", authorService.countAuthors());
		model.addAttribute("studentsCount", studentService.countStudents());
		return "dashboard";
	}	
}