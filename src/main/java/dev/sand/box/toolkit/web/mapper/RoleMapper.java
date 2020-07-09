package dev.sand.box.toolkit.web.mapper;

import dev.sand.box.toolkit.entity.role.Role;
import dev.sand.box.toolkit.service.role.RoleService;
import dev.sand.box.toolkit.web.dto.RoleDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper to transform {@link Role} <> {@link RoleDTO}
 */
@Mapper(config = MapperConfig.class)
public abstract class RoleMapper {
    /**
     * Instance of the interface implementation
     */
    static final RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Autowired
    private RoleService roleService;

    /**
     * To entity mapping
     *
     * @param roleDTO {@link RoleDTO}
     * @return {@link Role}
     */
    public abstract Role toEntity(RoleDTO roleDTO);

    /**
     * To DTO mapping
     *
     * @param role {@link Role}
     * @return {@link RoleDTO}
     */
    public abstract RoleDTO toDTO(Role role);

    /**
     * To list of {@link RoleDTO}
     *
     * @param roleList {@link List<Role>}
     * @return {@link List<RoleDTO>}
     */
    public List<RoleDTO> toDTOList(List<Role> roleList) {
        if (roleList == null) {
            return new ArrayList<>();
        }
        return roleList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @BeforeMapping
    public void defineRights(Role role, @MappingTarget RoleDTO dto) {
        dto.setHasRights("ADM".equalsIgnoreCase(role.getCode()));
    }

    @AfterMapping
    public void adjustCode(@MappingTarget RoleDTO dto) {
        dto.setCode(dto.getCode().toUpperCase());
    }

    @ObjectFactory
    public Role resolve(RoleDTO roleDTO) {
        Role role = roleService.findByCode(roleDTO.getCode());
        return role != null ? role : new Role();
    }
}
