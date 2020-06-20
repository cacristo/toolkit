package dev.sand.box.toolkit.web.webservices;

import dev.sand.box.toolkit.entity.role.Role;
import dev.sand.box.toolkit.service.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Web Service responsible to roles.
 */
@RestController
@RequestMapping(value = "/roles")
public class RolesWS {
    private static final Logger LOG = LoggerFactory.getLogger(RolesWS.class);

    private final RoleService roleService;

    public RolesWS(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllDTORoles() {
        LOG.info("GET /all-roles");
        return roleService.allRoles();
    }
}
