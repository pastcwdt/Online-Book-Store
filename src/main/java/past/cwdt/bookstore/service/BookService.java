package past.cwdt.bookstore.service;

import java.util.List;
import past.cwdt.bookstore.dto.BookDto;
import past.cwdt.bookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> findAll();
}
