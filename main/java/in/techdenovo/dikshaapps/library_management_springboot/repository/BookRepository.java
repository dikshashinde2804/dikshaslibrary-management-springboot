package in.techdenovo.dikshaapps.library_management_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.techdenovo.dikshaapps.library_management_springboot.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
