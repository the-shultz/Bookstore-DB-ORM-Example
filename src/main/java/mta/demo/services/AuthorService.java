package mta.demo.services;

import mta.demo.entities.Author;
import mta.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> list() {
        return authorRepository.findAll();
    }

    public Long count() { return authorRepository.count(); }

    public Author getById(Long id){ return authorRepository.getById(id); }
}
