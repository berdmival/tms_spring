package by.tms.spring.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static int idIncrementer;
    private int id;
    private String name;
    private String email;
    private int age;
    private String password;
    private boolean isLogin;

    public User() {
    }

    public User(String name, String email, int age, String password) {
        this.email = email;
        this.id = idIncrementer++;
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

    public int getId() {
        return id;
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
