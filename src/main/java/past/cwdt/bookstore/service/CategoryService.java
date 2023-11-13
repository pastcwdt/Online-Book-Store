package past.cwdt.bookstore.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import past.cwdt.bookstore.dto.category.CategoryDto;
import past.cwdt.bookstore.dto.category.CreateCategoryRequestDto;

public interface CategoryService {
    List<CategoryDto> findAll(Pageable pageable);

    CategoryDto getById(Long id);

    CategoryDto save(CreateCategoryRequestDto categoryDto);

    CategoryDto update(Long id, CreateCategoryRequestDto categoryDto);

    void deleteById(Long id);
}
