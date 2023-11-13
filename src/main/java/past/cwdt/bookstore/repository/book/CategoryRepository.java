package past.cwdt.bookstore.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import past.cwdt.bookstore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
