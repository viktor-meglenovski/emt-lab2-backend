package backend.lab2.emt.demo.web;

import backend.lab2.emt.demo.model.Author;
import backend.lab2.emt.demo.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://emt-lab2-frontend-191001.herokuapp.com")
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAllAuthors(){
        return authorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id){
        return authorService.findById(id).
                map(author->ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
