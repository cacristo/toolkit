package dev.sand.box.toolkit.service.role;

import dev.sand.box.toolkit.entity.role.Role;

import java.util.List;

/**
 * Interface to manage {@link Role} object
 */
@FunctionalInterface
public interface RoleService {
    /**
     * List of all roles available.
     *
     * @return {@link List<Role>}
     */
    List<Role> allRoles();
}
