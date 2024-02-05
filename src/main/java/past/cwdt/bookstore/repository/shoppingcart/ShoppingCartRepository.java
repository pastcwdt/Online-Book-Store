package past.cwdt.bookstore.repository.shoppingcart;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import past.cwdt.bookstore.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @EntityGraph(attributePaths = {"cartItems", "user", "cartItems.book"})
    Optional<ShoppingCart> findByUserId(Long id);
}
