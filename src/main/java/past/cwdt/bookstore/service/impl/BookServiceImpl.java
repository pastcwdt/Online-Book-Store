package past.cwdt.bookstore.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import past.cwdt.bookstore.dto.book.BookDto;
import past.cwdt.bookstore.dto.book.BookDtoSearchByParameters;
import past.cwdt.bookstore.dto.book.BookDtoWithoutCategoryIds;
import past.cwdt.bookstore.dto.book.CreateBookRequestDto;
import past.cwdt.bookstore.exceptions.EntityNotFoundException;
import past.cwdt.bookstore.mapper.BookMapper;
import past.cwdt.bookstore.model.Book;
import past.cwdt.bookstore.model.Category;
import past.cwdt.bookstore.repository.BookRepository;
import past.cwdt.bookstore.repository.book.CategoryRepository;
import past.cwdt.bookstore.repository.impl.BookSpecificationBuilder;
import past.cwdt.bookstore.service.BookService;

@RequiredArgsConstructor
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;
    private final CategoryRepository categoryRepository;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toBook(requestDto);
        setCategories(requestDto, book);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(()
                        -> new EntityNotFoundException("Can't find book by Id " + id));
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto requestDto) {
        checkIfBookExistsById(id);
        Book book = bookMapper.toBook(requestDto);
        setCategories(requestDto, book);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        checkIfBookExistsById(id);
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> search(BookDtoSearchByParameters searchParameters) {
        return bookRepository.findAll(bookSpecificationBuilder.build(searchParameters))
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public List<BookDtoWithoutCategoryIds> findBooksByCategory(Pageable pageable, Long id) {
        return bookRepository.findAllByCategoryId(id).stream()
                .map(bookMapper::toDtoWithoutCategories)
                .toList();
    }

    private void checkIfBookExistsById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Can't find book with id " + id);
        }
    }

    private void setCategories(CreateBookRequestDto requestDto, Book book) {
        Set<Category> categorySet = requestDto.categoryIds().stream()
                .map(categoryRepository::getReferenceById)
                .collect(Collectors.toSet());
        book.setCategories(categorySet);
    }
}
