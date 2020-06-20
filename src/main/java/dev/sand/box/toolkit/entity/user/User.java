package dev.sand.box.toolkit.entity.user;

import dev.sand.box.toolkit.entity.role.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Table User.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String phone;

    @Column
    @NotNull
    private String activity;

    @OneToOne
    @JoinColumn(name = "roleCode", referencedColumnName = "code", foreignKey = @ForeignKey(name = "USER_ROLE_ID_FK"))
    @NotNull
    private Role role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
