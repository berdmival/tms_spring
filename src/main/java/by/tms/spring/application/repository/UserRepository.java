package by.tms.spring.application.repository;

import by.tms.spring.application.model.user.User;

import java.util.List;

public interface UserRepository {

    void add(User user);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findById(int id);

    List<User> findOnline();
}
