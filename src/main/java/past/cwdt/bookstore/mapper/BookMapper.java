package past.cwdt.bookstore.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import past.cwdt.bookstore.dto.book.BookDto;
import past.cwdt.bookstore.dto.book.BookDtoWithoutCategoryIds;
import past.cwdt.bookstore.dto.book.CreateBookRequestDto;
import past.cwdt.bookstore.model.Book;
import past.cwdt.bookstore.model.Category;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        implementationPackage = "<PACKAGE_NAME>.impl"
)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toBook(CreateBookRequestDto requestDto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        bookDto.setCategoryIds(book.getCategories().stream()
                .map(Category::getId)
                .toList());
    }
}
