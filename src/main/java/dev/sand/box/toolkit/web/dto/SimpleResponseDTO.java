package dev.sand.box.toolkit.web.dto;

import java.io.Serializable;

public class SimpleResponseDTO implements Serializable {

    private int status;
    private String message;

    /**
     * Default constructor
     */
    public SimpleResponseDTO() {
        /* empty constructor */
    }

    /**
     * Constructor with params
     *
     * @param status  the status of the response
     * @param message the message of the response
     */
    public SimpleResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}