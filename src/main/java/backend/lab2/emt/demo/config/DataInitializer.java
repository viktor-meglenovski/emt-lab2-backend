package backend.lab2.emt.demo.config;

import backend.lab2.emt.demo.model.Author;
import backend.lab2.emt.demo.model.Book;
import backend.lab2.emt.demo.model.Country;
import backend.lab2.emt.demo.model.enumerations.Category;
import backend.lab2.emt.demo.repository.AuthorRepository;
import backend.lab2.emt.demo.repository.BookRepository;
import backend.lab2.emt.demo.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initData() {
        //Countries
        Country macedonia=new Country("Macedonia","Europe");
        Country usa=new Country("United States of America","North America");
        Country france=new Country("France","Europe");
        Country australia=new Country("Australia", "Australia");
        Country egypt=new Country("Egypt","Africa");
        Country japan=new Country("Japan","Asia");
        Country india=new Country("India","Asia");
        Country england=new Country("England","Europe");
        countryRepository.save(macedonia);
        countryRepository.save(usa);
        countryRepository.save(france);
        countryRepository.save(australia);
        countryRepository.save(egypt);
        countryRepository.save(japan);
        countryRepository.save(india);
        countryRepository.save(england);

        //Authors
        Author slavkoJanevski=new Author("Slavko","Janevski",macedonia);
        Author kostaPetrov=new Author("Kosta", "Petrov",macedonia);
        Author markTwain=new Author("Mark","Twain",usa);
        Author victorHugo=new Author("Victor","Hugo",france);
        Author yusufIdriz=new Author("Yusuf","Idriz",egypt);
        Author natsuoKirino=new Author("Natsuo","Kirino",japan);
        Author ruskinBond=new Author("Ruskin","Bond",india);
        Author williamShakespeare=new Author("William","Shakespeare",england);
        authorRepository.save(slavkoJanevski);
        authorRepository.save(kostaPetrov);
        authorRepository.save(markTwain);
        authorRepository.save(victorHugo);
        authorRepository.save(yusufIdriz);
        authorRepository.save(natsuoKirino);
        authorRepository.save(ruskinBond);
        authorRepository.save(williamShakespeare);

        //Books
        Book ulica=new Book("Ulica", Category.NOVEL,slavkoJanevski,15);
        Book stravot=new Book("Stravot",Category.BIOGRAPHY,kostaPetrov,20);
        Book lifeOnTheMississippi=new Book("Life on the Mississippi",Category.NOVEL,markTwain,5);
        Book lesMiserables=new Book("Les Miserables",Category.DRAMA,victorHugo,40);
        Book houseOfFlesh=new Book("House of Flesh", Category.FANTASY,yusufIdriz,3);
        Book out=new Book("Out",Category.THRILLER,natsuoKirino,7);
        Book angryRiver=new Book("Angry River",Category.FANTASY,ruskinBond, 12);
        Book hamlet=new Book("Hamlet",Category.CLASSICS,williamShakespeare,16);
        bookRepository.save(ulica);
        bookRepository.save(stravot);
        bookRepository.save(lifeOnTheMississippi);
        bookRepository.save(lesMiserables);
        bookRepository.save(houseOfFlesh);
        bookRepository.save(out);
        bookRepository.save(angryRiver);
        bookRepository.save(hamlet);
    }
}
