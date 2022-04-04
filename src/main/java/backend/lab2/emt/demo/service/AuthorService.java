package backend.lab2.emt.demo.service;

import backend.lab2.emt.demo.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public List<Author> findAll();
    public Optional<Author> findById(Long id);
}
