package dev.sand.box.toolkit.web.mapper;

import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.web.dto.RoleDTO;
import dev.sand.box.toolkit.web.dto.UserDTO;
import dev.sand.box.toolkit.web.dto.UserQuickSearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test {@link UserMapper}
 */
public class UserMapperTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void testToEntity() {
        LOG.info("test toEntity");
        //given
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Jane");
        userDTO.setLastName("Doe");
        userDTO.setActivity("Admin");
        userDTO.setEmail("jane.doe@gmail.com");
        userDTO.setPhone("222 0000 111");

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("Admin");
        roleDTO.setCode("adm");
        userDTO.setRole(roleDTO);

        //when
        User user = UserMapper.INSTANCE.toEntity(userDTO);

        //then
        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Jane");
        assertThat(user.getLastName()).isEqualTo("Doe");
        assertThat(user.getActivity()).isEqualTo("Admin");
        assertThat(user.getEmail()).isEqualTo("jane.doe@gmail.com");
        assertThat(user.getPhone()).isEqualTo("222 0000 111");
        // sub clss
        assertThat(user.getRole()).isNotNull();
        assertThat(user.getRole().getCode()).isEqualTo("adm");
        assertThat(user.getRole().getName()).isEqualTo("Admin");

    }

    @Test
    public void testToDTO() {
        LOG.info("test toDTO");
        //given
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setActivity("Admin");
        user.setEmail("john.doe@gmail.com");
        user.setPhone("111 0000 222");

        //when
        UserDTO userDTO = UserMapper.INSTANCE.toDTO(user);

        //then
        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getFirstName()).isEqualTo("John");
        assertThat(userDTO.getLastName()).isEqualTo("Doe");
        assertThat(userDTO.getActivity()).isEqualTo("Admin");
        assertThat(userDTO.getEmail()).isEqualTo("john.doe@gmail.com");
        assertThat(userDTO.getPhone()).isEqualTo("111 0000 222");
    }

    @Test
    public void testToUserQuickSearchDTO() {
        LOG.info("test toQuickSearchDTO");
        //given
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setActivity("Admin");
        user.setEmail("john.doe@gmail.com");
        user.setPhone("111 0000 222");

        //when
        UserQuickSearchDTO userQuickSearchDTO = UserMapper.INSTANCE.toUserQuickSearchDTO(user);

        //then
        assertThat(userQuickSearchDTO).isNotNull();
        assertThat(userQuickSearchDTO.getName()).isEqualTo("John Doe");
        assertThat(userQuickSearchDTO.getRole()).isNull();
    }

    @Test
    public void testToDTOList() {
        LOG.info("test toDTOList");
        //given
        User john = new User();
        john.setFirstName("John");
        john.setLastName("Doe");
        john.setActivity("Admin");
        john.setEmail("john.doe@gmail.com");
        john.setPhone("111 0000 222");

        User jane = new User();
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane.setActivity("Admin");
        jane.setEmail("jane.doe@gmail.com");
        jane.setPhone("222 0000 111");

        List<User> userList = new ArrayList<>();
        userList.add(0, jane);
        userList.add(1, john);

        //when
        List<UserDTO> userDTOList = UserMapper.INSTANCE.toDTOList(userList);

        //then
        assertThat(userDTOList).isNotNull();
        assertThat(userDTOList.size()).isEqualTo(2);

        // item 0
        assertThat(userDTOList.get(0).getFirstName()).isEqualTo("Jane");
        assertThat(userDTOList.get(0).getLastName()).isEqualTo("Doe");

        // item 1
        assertThat(userDTOList.get(1).getFirstName()).isEqualTo("John");
        assertThat(userDTOList.get(1).getActivity()).isEqualTo("Admin");
    }

    @Test
    public void testToUserQuickSearchDTOList() {
        LOG.info("test toDTOList");
        //given
        User john = new User();
        john.setFirstName("John");
        john.setLastName("Doe");
        john.setActivity("Admin");
        john.setEmail("john.doe@gmail.com");
        john.setPhone("111 0000 222");

        User jane = new User();
        jane.setFirstName("Jane");
        jane.setLastName("Doe");
        jane.setActivity("Admin");
        jane.setEmail("jane.doe@gmail.com");
        jane.setPhone("222 0000 111");

        List<User> userList = new ArrayList<>();
        userList.add(0, jane);
        userList.add(1, john);

        //when
        List<UserQuickSearchDTO> userQuickSearchDTOList = UserMapper.INSTANCE.toUserQuickSearchDTOList(userList);

        //then
        assertThat(userQuickSearchDTOList).isNotNull();
        assertThat(userQuickSearchDTOList.size()).isEqualTo(2);

        // item 0
        assertThat(userQuickSearchDTOList.get(0).getName()).isEqualTo("Jane Doe");
        assertThat(userQuickSearchDTOList.get(0).getRole()).isNull();

        // item 1
        assertThat(userQuickSearchDTOList.get(1).getName()).isEqualTo("John Doe");
        assertThat(userQuickSearchDTOList.get(1).getRole()).isNull();
    }

    @Test
    public void testNameConverter() {
        LOG.info("test nameConverter");
        //given
        String firstName = "John";
        String tag = "'The Kid'";
        String lastName = "Doe";

        //when
        String nameComplete = UserMapper.INSTANCE.nameConverter(firstName, lastName);
        String fullName = UserMapper.INSTANCE.nameConverter(firstName, tag, lastName);

        //then
        assertThat(fullName).isNotNull();
        assertThat(fullName).isEqualTo("John 'The Kid' Doe");

        assertThat(nameComplete).isNotNull();
        assertThat(nameComplete).isEqualTo("John Doe");
    }
}