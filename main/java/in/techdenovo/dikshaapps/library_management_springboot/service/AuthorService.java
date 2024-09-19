package in.techdenovo.dikshaapps.library_management_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.techdenovo.dikshaapps.library_management_springboot.model.Author;
import in.techdenovo.dikshaapps.library_management_springboot.model.Book;
import in.techdenovo.dikshaapps.library_management_springboot.model.Category;
import in.techdenovo.dikshaapps.library_management_springboot.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public Author addAuthor(Author author) {
		
		return authorRepository.save(author);
		
	}
	public List<Author> allAuthors() {
		
		return authorRepository.findAll();
	}
	
public void deleteAuthor(int id) {
		
	Author existingAuthor = authorRepository.findById(id).orElse(null);
		if(existingAuthor!=null) {
			authorRepository.delete(existingAuthor);
		}
	}
	public Author findAuthor(int id) {
		return authorRepository.findById(id).orElse(null);
	}
	public Author updateAuthor(Author author) {
		Author existingAuthor = authorRepository.findById(author.getId()).orElse(null);
		if(existingAuthor!=null) {
			existingAuthor.setFirstName(author.getFirstName());
			existingAuthor.setLastName(author.getLastName());
		}
		return authorRepository.save(existingAuthor);
		
	}
	public long countAuthors() {
		return authorRepository.count();
	}
	
}
