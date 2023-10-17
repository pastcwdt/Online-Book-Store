package past.cwdt.bookstore;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import past.cwdt.bookstore.model.Book;
import past.cwdt.bookstore.service.BookService;

@SpringBootApplication
public class OnlineBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return args -> {
            Book firstBook = new Book();
            firstBook.setAuthor("Author");
            firstBook.setTitle("Title");
            firstBook.setPrice(BigDecimal.valueOf(100));
            firstBook.setIsbn("x121221sxs");
            bookService.save(firstBook);
            System.out.println(bookService.findAll());
        };
    }
}
