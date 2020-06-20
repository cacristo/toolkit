package dev.sand.box.toolkit.repository.user;

import dev.sand.box.toolkit.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository use only for the entity {@link User}
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
