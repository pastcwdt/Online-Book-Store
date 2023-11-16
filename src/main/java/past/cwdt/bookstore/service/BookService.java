package past.cwdt.bookstore.service;

import java.util.List;
import past.cwdt.bookstore.dto.BookDto;
import past.cwdt.bookstore.dto.BookDtoSearchByParameters;
import past.cwdt.bookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> findAll();

    BookDto update(Long id, CreateBookRequestDto requestDto);

    void deleteById(Long id);

    List<BookDto> search(BookDtoSearchByParameters searchParameters);
}
