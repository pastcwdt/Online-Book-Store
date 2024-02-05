package past.cwdt.bookstore.service;

import past.cwdt.bookstore.dto.shoppingcart.CartItemDto;
import past.cwdt.bookstore.dto.shoppingcart.CartItemRequestDto;
import past.cwdt.bookstore.dto.shoppingcart.CartItemUpdateDto;
import past.cwdt.bookstore.dto.shoppingcart.ShoppingCartDto;

public interface ShoppingCartService {
    ShoppingCartDto getShoppingCart();

    CartItemDto addCartItem(CartItemRequestDto requestDto);

    CartItemDto updateCartItem(Long itemId, CartItemUpdateDto updateDto);

    void removeCartItem(Long itemId);
}
