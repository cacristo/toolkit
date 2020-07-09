package dev.sand.box.toolkit.web.dto;

import java.io.Serializable;

/**
 * Role object
 */
public class RoleDTO implements Serializable {
    private String code;
    private String name;
    private boolean hasRights;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasRights() {
        return hasRights;
    }

    public void setHasRights(boolean hasRights) {
        this.hasRights = hasRights;
    }
}
