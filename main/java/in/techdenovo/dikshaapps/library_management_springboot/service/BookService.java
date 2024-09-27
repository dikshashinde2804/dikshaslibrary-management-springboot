package in.techdenovo.dikshaapps.library_management_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.techdenovo.dikshaapps.library_management_springboot.model.Author;
import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public Book addBook(Book book) {
		
		return bookRepository.save(book);
		
	}
    public List<Book> allBooks() {
		
		return bookRepository.findAll();
	}
    
    
	public void deleteBook(int id) {
		
		Book existingBook = bookRepository.findById(id).orElse(null);
		if(existingBook!=null) {
			bookRepository.delete(existingBook);
		}
	}
	public Book findBook(int id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book updateBook(Book book) {
		Book existingBook = bookRepository.findById(book.getBookId()).orElse(null);
		if(existingBook!=null) {
			existingBook.setBookName(book.getBookName());
			existingBook.setIsbn(book.getIsbn());
			existingBook.setPrice(book.getPrice());
		}
		return bookRepository.save(existingBook);
		
	}
	public long countBooks() {
		return bookRepository.count();	}
}

