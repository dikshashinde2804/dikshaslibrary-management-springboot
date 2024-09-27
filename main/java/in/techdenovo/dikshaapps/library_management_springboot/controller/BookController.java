package in.techdenovo.dikshaapps.library_management_springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.techdenovo.dikshaapps.library_management_springboot.model.Author;
import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/add")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addbook";
		
	}
	@PostMapping("/add")
	public String addBook(@ModelAttribute("book") Book book) {
//		System.out.println(book.getBookName() + " "+book.getIsbn()+ " "+ book.getPrice());
		bookService.addBook(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("/list")
	public String allBooks(Model model) {
		List<Book> books = new ArrayList<>();
		books= bookService.allBooks();
		model.addAttribute("books", books);
		return "listbook";
	}
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id,Model model) {
		bookService.deleteBook(id);
		return "redirect:/book/list";
	}
	@GetMapping("/update/{id}")
	public String updateBook(@PathVariable("id") int id,Model model) {
		Book existingBook = bookService.findBook(id);
		model.addAttribute("book", existingBook);
		return "editbook";
	}
	@PostMapping("/update")
	public String updateBook(@ModelAttribute("book") Book book) {
		bookService.updateBook(book);
		return "redirect:/book/list";
	}
} 
