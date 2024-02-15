package guru.springframework.web.aplication.bootstrap;

import guru.springframework.web.aplication.model.Author;
import guru.springframework.web.aplication.model.Book;
import guru.springframework.web.aplication.model.Publisher;
import guru.springframework.web.aplication.repository.AuthorRepository;
import guru.springframework.web.aplication.repository.BookRepository;
import guru.springframework.web.aplication.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class BootStrapData implements CommandLineRunner {

    private static final Logger log = Logger.getLogger(BootStrapData.class.getName());

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = Author.builder()
                .firstName("Eric")
                .lastName("Evans")
                .books(new HashSet<>())
                .build();
        Book ddd = Book.builder()
                .title("Domain Driven Design")
                .isbn("1234-4464v")
                .authors(new HashSet<>())
                .build();
        Publisher publisher = Publisher.builder()
                .name("Publisher")
                .addressLine1("Camino a Mexico")
                .city("Austin")
                .state("Texas")
                .zip("12345")
                .build();

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = Author.builder()
                .firstName("Rod")
                .lastName("Johnson")
                .books(new HashSet<>())
                .build();
        Book noEJB = Book.builder()
                .title("J2EE Development without EJB")
                .isbn("3323158741559")
                .authors(new HashSet<>())
                .build();

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        log.info("Started in Bootstrap");
        log.info("Number of books: " + bookRepository.count());
        log.info("Number of publishers: " + publisherRepository.count());
    }
}
