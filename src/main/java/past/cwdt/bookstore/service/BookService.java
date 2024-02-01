package past.cwdt.bookstore.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import past.cwdt.bookstore.dto.book.BookDto;
import past.cwdt.bookstore.dto.book.BookDtoSearchByParameters;
import past.cwdt.bookstore.dto.book.BookDtoWithoutCategoryIds;
import past.cwdt.bookstore.dto.book.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> findAll(Pageable pageable);

    BookDto update(Long id, CreateBookRequestDto requestDto);

    void deleteById(Long id);

    List<BookDto> search(BookDtoSearchByParameters searchParameters);

    List<BookDtoWithoutCategoryIds> findBooksByCategory(Pageable pageable, Long id);
}
