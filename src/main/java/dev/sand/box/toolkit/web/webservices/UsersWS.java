package dev.sand.box.toolkit.web.webservices;

import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Web Service responsible to users.
 */
@RestController
@RequestMapping(value = "/users")
public class UsersWS {
    private static final Logger LOG = LoggerFactory.getLogger(UsersWS.class);

    private final UserService userService;

    public UsersWS(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllDTOUsers() {
        LOG.info("GET /all-users");
        return userService.allUsers();
    }

    @GetMapping("/quick-search")
    public List<User> getAllQuickSearchUsers() {
        LOG.info("GET /quick-search");
        return userService.allUsers();
    }
}
