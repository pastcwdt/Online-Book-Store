package past.cwdt.bookstore.repository.order;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import past.cwdt.bookstore.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findByIdAndOrderId(Long itemId, Long orderId);

    List<OrderItem> findAllByOrderId(Long id);
}
