package past.cwdt.bookstore.repository;

import org.springframework.data.jpa.domain.Specification;
import past.cwdt.bookstore.dto.BookDtoSearchByParameters;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookDtoSearchByParameters searchParameters);
}
