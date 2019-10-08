package by.tms.spring.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 7557510397232050349L;
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,64}")
    private String email;

    @Range(min = 7, max = 65)
    private int age;

    @NotBlank
    @Size(min = 4, max = 16)
    private String password;

    private boolean isLogin;

    public User() {
    }

    public User(String name, String email, int age, String password) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
        this.isLogin = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void login() {
        isLogin = true;
    }

    public void logout() {
        isLogin = false;
    }
}
