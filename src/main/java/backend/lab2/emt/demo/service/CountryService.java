package backend.lab2.emt.demo.service;

import backend.lab2.emt.demo.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> findAll();
    public Optional<Country> findById(Long id);
}
