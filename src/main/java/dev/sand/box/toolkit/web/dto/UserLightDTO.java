package dev.sand.box.toolkit.web.dto;

import java.io.Serializable;

/**
 * Light User object only with main info
 */
public class UserLightDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private RoleDTO role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
