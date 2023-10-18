package past.cwdt.bookstore.dto;

import lombok.Data;

@Data
public class BookDtoSearchByParameters {
    private String[] authors;
    private String[] titles;
}
