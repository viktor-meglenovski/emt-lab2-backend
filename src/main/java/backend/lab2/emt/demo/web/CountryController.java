package backend.lab2.emt.demo.web;

import backend.lab2.emt.demo.model.Country;
import backend.lab2.emt.demo.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> findAllCountries(){
        return countryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable Long id){
        return countryService.findById(id)
                .map(country->ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
