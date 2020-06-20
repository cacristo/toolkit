package dev.sand.box.toolkit.web.mapper;

import dev.sand.box.toolkit.entity.role.Role;
import dev.sand.box.toolkit.web.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper to transform {@link Role} <> {@link RoleDTO}
 */
@Mapper
public interface RoleMapper {
    /**
     * Instance of the interface implementation
     */
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    /**
     * To entity mapping
     *
     * @param roleDTO {@link RoleDTO}
     * @return {@link Role}
     */
    Role toEntity(RoleDTO roleDTO);

    /**
     * To DTO mapping
     *
     * @param role {@link Role}
     * @return {@link RoleDTO}
     */
    RoleDTO toDTO(Role role);

    /**
     * To list of {@link RoleDTO}
     *
     * @param roleList {@link List<Role>}
     * @return {@link List<RoleDTO>}
     */
    default List<RoleDTO> toDTOList(List<Role> roleList) {
        if (roleList == null) {
            return new ArrayList<>();
        }
        return roleList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
