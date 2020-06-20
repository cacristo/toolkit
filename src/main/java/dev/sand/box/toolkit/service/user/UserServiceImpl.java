package dev.sand.box.toolkit.service.user;

import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.repository.user.UserRepository;
import dev.sand.box.toolkit.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to manage {@link User} object
 */
@Service
public class UserServiceImpl extends AbstractService<UserRepository, User, Long> implements UserService {

    /**
     * Constructor
     */
    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findById(Long id) {
        return getRepository().findById(id).orElse(null);
    }

    /**
     * @see UserService#allUsers() for more information
     */
    @Override
    public List<User> allUsers() {
        return getRepository().findAll();
    }

    /**
     * @see UserService#edit(User) for more information
     */
    @Override
    public User edit(User users) {
        User entitySaved = null;
        Optional<User> optionalUser = getRepository().findById(users.getId());
        if (optionalUser.isPresent()) {
            User entity = optionalUser.get();
            entity.setRole(users.getRole());
            entitySaved = getRepository().save(entity);
        }
        return entitySaved;
    }
}
