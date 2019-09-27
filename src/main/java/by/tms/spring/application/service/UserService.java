package by.tms.spring.application.service;

import by.tms.spring.application.model.user.User;

public interface UserService {

    boolean register(User user);

    User login(String email, String password);

    User logout(int id);
}
