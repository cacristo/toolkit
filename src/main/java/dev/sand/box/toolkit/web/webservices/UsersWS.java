package dev.sand.box.toolkit.web.webservices;

import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.service.user.UserService;
import dev.sand.box.toolkit.web.dto.UserDTO;
import dev.sand.box.toolkit.web.dto.UserQuickSearchDTO;
import dev.sand.box.toolkit.web.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getAllDTOUsers() {
        LOG.info("GET /all-users");
        return userMapper.toDTOList(userService.allUsers());
    }

    @GetMapping("/quick-search")
    public List<UserQuickSearchDTO> getAllQuickSearchUsers() {
        LOG.info("GET /quick-search");
        return userMapper.toUserQuickSearchDTOList(userService.allUsers());
    }
}
