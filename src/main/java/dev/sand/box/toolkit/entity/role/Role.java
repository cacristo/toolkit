package dev.sand.box.toolkit.entity.role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Table Role.
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @NotNull
    private String code;

    @Column
    @NotNull
    private String name;

    @Transient
    public String getRoleId() {
        return getCode();
    }

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
}
