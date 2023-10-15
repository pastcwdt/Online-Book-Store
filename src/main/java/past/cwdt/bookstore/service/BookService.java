package past.cwdt.bookstore.service;

import java.util.List;
import past.cwdt.bookstore.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
