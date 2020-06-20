package dev.sand.box.toolkit.web.dto;

import java.io.Serializable;

/**
 * Full User object
 */
public class UserDTO extends UserLightDTO implements Serializable {
    private String email;
    private String phone;
    private String activity;

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
}
