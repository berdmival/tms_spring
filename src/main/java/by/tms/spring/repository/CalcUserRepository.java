package by.tms.spring.repository;

import by.tms.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userRepository")
public class CalcUserRepository implements UserRepository {

    private final List<User> users;

    public CalcUserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users
        ) {
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        for (User user : users
        ) {
            if (user.getEmail().equals(email) & user.getPassword().equals(password)) return user;
        }
        return null;
    }

    @Override
    public User findById(int id) {
        for (User user : users
        ) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public List<User> findOnline() {
        List<User> onlineUsers = new ArrayList<>();
        for (User user : users
        ) {
            if (user.isLogin()) onlineUsers.add(user);
        }
        return onlineUsers;
    }

}
