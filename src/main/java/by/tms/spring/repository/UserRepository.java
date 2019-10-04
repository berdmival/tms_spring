package by.tms.spring.repository;

import by.tms.spring.model.User;

import java.util.List;

public interface UserRepository {

    void add(User user);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findById(long id);

    List<User> findOnline();
}
