package dev.sand.box.toolkit.web.dto;

import java.io.Serializable;

/**
 * User object used for quick search elements such as: auto-suggest component, ComboBox component, etc..
 */
public class UserQuickSearchDTO implements Serializable {
    private Long id;
    private String name;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
