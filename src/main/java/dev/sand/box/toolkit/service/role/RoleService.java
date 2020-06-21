package dev.sand.box.toolkit.service.role;

import dev.sand.box.toolkit.entity.role.Role;
import dev.sand.box.toolkit.entity.user.User;

import java.util.List;

/**
 * Interface to manage {@link Role} object
 */
public interface RoleService {
    Role findByCode(String code);
    /**
     * List of all roles available.
     *
     * @return {@link List<Role>}
     */
    List<Role> allRoles();
}
