package dev.sand.box.toolkit.web.mapper;

import dev.sand.box.toolkit.entity.user.User;
import dev.sand.box.toolkit.web.dto.UserDTO;
import dev.sand.box.toolkit.web.dto.UserQuickSearchDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Mapper to transform {@link User} <> {@link UserDTO}
 */
@Mapper
public interface UserMapper {
    /**
     * Instance of the interface implementation
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * To entity mapping
     *
     * @param userDTO {@link UserDTO}
     * @return {@link User}
     */
    User toEntity(UserDTO userDTO);

    /**
     * To DTO mapping
     *
     * @param user {@link User}
     * @return {@link UserDTO}
     */
    UserDTO toDTO(User user);

    /**
     * To QuickSearchDTO elements
     *
     * @param user {@link User}
     * @return {@link UserDTO}
     */
    @Mapping(target = "name", expression = "java(nameConverter(user.getFirstName(), user.getLastName()))")
    @Mapping(target = "role", source = "role.code")
    UserQuickSearchDTO toUserQuickSearchDTO(User user);

    /**
     * To list of {@link UserDTO}
     *
     * @param userList {@link List<User>}
     * @return {@link List<UserDTO>}
     */
    default List<UserDTO> toDTOList(List<User> userList) {
        if (userList == null) {
            return new ArrayList<>();
        }
        return userList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     * To list of {@link UserQuickSearchDTO}
     *
     * @param userList {@link List<User>}
     * @return {@link List<UserQuickSearchDTO>}
     */
    default List<UserQuickSearchDTO> toUserQuickSearchDTOList(List<User> userList) {
        if (userList == null) {
            return new ArrayList<>();
        }
        return userList.stream().map(this::toUserQuickSearchDTO).collect(Collectors.toList());
    }

    /**
     * Join first with last name as one String
     *
     * @param name the firstName and the lastName
     * @return the first last name as one
     */
    default String nameConverter(String... name) {
        return Stream.of(name).collect(Collectors.joining(" "));
    }
}
