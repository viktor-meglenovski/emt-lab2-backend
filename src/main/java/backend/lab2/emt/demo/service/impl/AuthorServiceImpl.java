package backend.lab2.emt.demo.service.impl;

import backend.lab2.emt.demo.model.Author;
import backend.lab2.emt.demo.model.exceptions.AuthorNotFoundException;
import backend.lab2.emt.demo.repository.AuthorRepository;
import backend.lab2.emt.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
