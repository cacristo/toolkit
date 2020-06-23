package dev.sand.box.toolkit.service.user;

import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.repository.user.UserRepository;
import dev.sand.box.toolkit.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
