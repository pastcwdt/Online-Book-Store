package past.cwdt.bookstore.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import past.cwdt.bookstore.dto.BookDto;
import past.cwdt.bookstore.dto.BookDtoSearchByParameters;
import past.cwdt.bookstore.dto.CreateBookRequestDto;
import past.cwdt.bookstore.exceptions.EntityNotFoundException;
import past.cwdt.bookstore.mapper.BookMapper;
import past.cwdt.bookstore.model.Book;
import past.cwdt.bookstore.repository.BookRepository;
import past.cwdt.bookstore.repository.impl.BookSpecificationBuilder;
import past.cwdt.bookstore.service.BookService;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

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

    @Override
    public BookDto update(Long id, CreateBookRequestDto requestDto) {
        Book bookToUpdate = bookRepository.findById(id)
                .orElseThrow(()
                        -> new EntityNotFoundException("Can't find book by id: " + id));
        bookMapper.updateBook(requestDto, bookToUpdate);
        Book updatedBook = bookRepository.save(bookToUpdate);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> search(BookDtoSearchByParameters searchParameters) {
        return bookRepository.findAll(bookSpecificationBuilder.build(searchParameters))
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
