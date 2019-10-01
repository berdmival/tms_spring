package by.tms.spring.model;

import java.io.Serializable;

public class AuthData implements Serializable {
    private String email;
    private String password;

    public AuthData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}