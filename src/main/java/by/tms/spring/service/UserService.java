package by.tms.spring.service;

import by.tms.spring.model.AuthData;
import by.tms.spring.model.User;

import java.util.List;

public interface UserService {

    boolean register(User user);

    User login(String email, String password);

    User logout(int id);

    List<User> findOnlineUsers();

    User login(AuthData authData);
}
