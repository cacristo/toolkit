package dev.sand.box.toolkit.service.user;

import dev.sand.box.toolkit.entity.user.User;

import java.util.List;

/**
 * Interface to manage {@link User} object
 */
public interface UserService {

    User findById(Long id);
    /**
     * List of all roles available.
     *
     * @return {@link List <User>}
     */
    List<User> allUsers();
}
