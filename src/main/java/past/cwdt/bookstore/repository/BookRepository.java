package past.cwdt.bookstore.repository;

import java.util.List;
import past.cwdt.bookstore.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
