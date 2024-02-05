package past.cwdt.bookstore.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import past.cwdt.bookstore.dto.order.CreateOrderRequestDto;
import past.cwdt.bookstore.dto.order.OrderDto;
import past.cwdt.bookstore.dto.order.OrderItemDto;
import past.cwdt.bookstore.dto.order.UpdateStatusRequestDto;

public interface OrderService {
    OrderDto addOrder(CreateOrderRequestDto requestDto);

    List<OrderDto> getOrders(Pageable pageable);

    OrderDto updateOrder(Long id, UpdateStatusRequestDto requestDto);

    List<OrderItemDto> getOrderItemsByOrder(Long id);

    OrderItemDto getOrderItemById(Long orderId, Long id);
}
