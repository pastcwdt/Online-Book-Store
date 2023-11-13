package past.cwdt.bookstore.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequestDto(
        @NotBlank
        @Size(max = 50)
        String name,
        @Size(max = 255)
        String description) {
}
