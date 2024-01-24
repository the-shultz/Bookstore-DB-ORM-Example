package mta.demo.services;

import mta.demo.entities.Author;
import mta.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> list() {
        return authorRepository.findAll();
    }

    public Long count() { return authorRepository.count(); }

    public Author getById(Long id){ return authorRepository.getById(id); }
}
