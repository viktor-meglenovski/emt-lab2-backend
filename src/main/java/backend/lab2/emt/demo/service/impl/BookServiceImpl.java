package backend.lab2.emt.demo.service.impl;

import backend.lab2.emt.demo.model.Author;
import backend.lab2.emt.demo.model.Book;
import backend.lab2.emt.demo.model.dto.BookDto;
import backend.lab2.emt.demo.model.exceptions.AuthorNotFoundException;
import backend.lab2.emt.demo.model.exceptions.BookNotFoundException;
import backend.lab2.emt.demo.repository.BookRepository;
import backend.lab2.emt.demo.service.AuthorService;
import backend.lab2.emt.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> add(BookDto bookDto) {
        Author a=authorService.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        Book b=new Book(bookDto.getName(),bookDto.getCategory(),a,bookDto.getAvailableCopies());
        bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book b= bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Author a=authorService.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        b.setName(bookDto.getName());
        b.setCategory(bookDto.getCategory());
        b.setAuthor(a);
        b.setAvailableCopies(bookDto.getAvailableCopies());
        bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public void delete(Long id) {
        Book b=findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.delete(b);
    }

    @Override
    public void getCopy(Long id) {
        Book b=findById(id)
                .orElseThrow(BookNotFoundException::new);
        b.getCopy();
        bookRepository.save(b);
    }

    @Override
    public void addCopy(Long id) {
        Book b=findById(id)
                .orElseThrow(BookNotFoundException::new);
        b.addCopy();
        bookRepository.save(b);
    }
}
