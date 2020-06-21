package dev.sand.box.toolkit.service.role;

import dev.sand.box.toolkit.entity.role.Role;
import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.repository.role.RoleRepository;
import dev.sand.box.toolkit.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage {@link Role} object
 */
@Service
public class RoleServiceImpl extends AbstractService<RoleRepository, Role, String> implements RoleService {

    /**
     * Constructor
     */
    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }

    @Override
    public Role findByCode(String code) {
        return getRepository().findById(code).orElse(null);
    }

    /**
     * @see RoleService#allRoles() for more information
     */
    @Override
    public List<Role> allRoles() {
        return getRepository().findAll();
    }
}
