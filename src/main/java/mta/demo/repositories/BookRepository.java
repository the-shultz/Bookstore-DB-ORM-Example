package mta.demo.repositories;

import mta.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List <Book> findByTitle(String Title);

    List <Book> findByTitleContaining(String Title);

    List <Book> findByPublisher_id(long id);
}
