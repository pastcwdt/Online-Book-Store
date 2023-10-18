package past.cwdt.bookstore.repository;

import java.util.List;
import java.util.Optional;
import past.cwdt.bookstore.model.Book;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();
}
