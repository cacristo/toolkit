package dev.sand.box.toolkit.web.mapper;

import dev.sand.box.toolkit.entity.role.Role;
import dev.sand.box.toolkit.web.dto.RoleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test {@link RoleMapper}
 */
public class RoleMapperTest {
    private static final Logger LOG = LoggerFactory.getLogger(RoleMapperTest.class);

    @Test
    public void testToDTO() {
        LOG.info("test toDTO");
        //given
        Role role = new Role();
        role.setCode("ADM");
        role.setName("Administrator");

        //when
        RoleDTO roleDTO = RoleMapper.INSTANCE.toDTO(role);

        //then
        assertThat(roleDTO).isNotNull();
        assertThat(roleDTO.getCode()).isEqualTo("ADM");
        assertThat(roleDTO.getName()).isEqualTo("Administrator");
    }

    @Test
    public void testToEntity() {
        LOG.info("test toEntity");
        //given
        RoleDTO role = new RoleDTO();
        role.setCode("ADM");
        role.setName("Administrator");

        //when
        Role roleDTO = RoleMapper.INSTANCE.toEntity(role);

        //then
        assertThat(roleDTO).isNotNull();
        assertThat(roleDTO.getCode()).isEqualTo("ADM");
        assertThat(roleDTO.getName()).isEqualTo("Administrator");
    }

    @Test
    public void testToDTOList() {
        LOG.info("test toDTOList");
        //given
        Role role1 = new Role();
        role1.setCode("ADM");
        role1.setName("Administrator");

        Role role2 = new Role();
        role2.setCode("CTR");
        role2.setName("Controller");

        List<Role> roleList = new ArrayList<>();
        roleList.add(0, role1);
        roleList.add(1, role2);

        //when
        List<RoleDTO> roleDTOList = RoleMapper.INSTANCE.toDTOList(roleList);

        //then
        assertThat(roleDTOList).isNotNull();
        assertThat(roleDTOList.size()).isEqualTo(2);

        // item 0
        assertThat(roleDTOList.get(0).getCode()).isEqualTo("ADM");
        assertThat(roleDTOList.get(0).getName()).isEqualTo("Administrator");

        // item 1
        assertThat(roleDTOList.get(1).getCode()).isEqualTo("CTR");
        assertThat(roleDTOList.get(1).getName()).isEqualTo("Controller");
    }
}
