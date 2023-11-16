package past.cwdt.bookstore.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import past.cwdt.bookstore.model.Role;
import past.cwdt.bookstore.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(RoleName name);
}
