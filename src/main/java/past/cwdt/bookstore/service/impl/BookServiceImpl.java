package past.cwdt.bookstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import past.cwdt.bookstore.dto.BookDto;
import past.cwdt.bookstore.dto.CreateBookRequestDto;
import past.cwdt.bookstore.exceptions.EntityNotFoundException;
import past.cwdt.bookstore.mapper.BookMapper;
import past.cwdt.bookstore.repository.BookRepository;
import past.cwdt.bookstore.service.BookService;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toBook(requestDto)));
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(()
                        -> new EntityNotFoundException("Can't find book by Id " + id));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
