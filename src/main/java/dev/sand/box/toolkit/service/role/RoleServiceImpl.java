package dev.sand.box.toolkit.service.role;

import dev.sand.box.toolkit.entity.role.Role;
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
    protected RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }

    /**
     * @see RoleService#allRoles() for more information
     */
    @Override
    public List<Role> allRoles() {
        return getRepository().findAll();
    }
}
