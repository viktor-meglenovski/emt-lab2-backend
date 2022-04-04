package backend.lab2.emt.demo.web;

import backend.lab2.emt.demo.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "https://emt-lab2-frontend-191001.herokuapp.com")
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping
    public List<Category> getAllCategories(){
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}
