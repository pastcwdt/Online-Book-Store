package past.cwdt.bookstore.dto.shoppingcart;

public record CartItemDto(Long id,
                          Long bookId,
                          String bookTitle,
                          Integer quantity) {
}
