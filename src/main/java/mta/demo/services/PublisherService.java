package mta.demo.services;

import mta.demo.entities.Publisher;
import mta.demo.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> list() {
        return publisherRepository.findAll();
    }

    public Long count() { return publisherRepository.count(); }

    public Publisher getById(Long id){ return publisherRepository.getById(id); }

}
