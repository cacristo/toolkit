package dev.sand.box.toolkit.repository.role;

import dev.sand.box.toolkit.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository use only for the entity {@link Role}
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
