package by.tms.spring.application.repository;

import by.tms.spring.application.model.user.User;

public interface UserRepository {

    void add(User user);

    User findByName(String name);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findById(int id);
}
