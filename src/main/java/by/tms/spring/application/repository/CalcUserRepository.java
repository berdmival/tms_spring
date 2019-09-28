package by.tms.spring.application.repository;

import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userRepository")
public class CalcUserRepository implements UserRepository {

    private final List<User> users;

    @Autowired
    public CalcUserRepository(@Qualifier("users") List<User> users) {
        this.users = users;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public CalcUser findByEmail(String email) {
        for (User u : users
        ) {
            CalcUser user = (CalcUser) u;
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public CalcUser findByEmailAndPassword(String email, String password) {
        for (User u : users
        ) {
            CalcUser user = (CalcUser) u;
            if (user.getEmail().equals(email) & user.getPassword().equals(password)) return user;
        }
        return null;
    }

    @Override
    public CalcUser findById(int id) {
        for (User u : users
        ) {
            CalcUser user = (CalcUser) u;
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public List<User> findOnline() {
        List<User> onlineUsers = new ArrayList<>();
        for (User u : users
        ) {
            CalcUser user = (CalcUser) u;
            if (user.isLogin()) onlineUsers.add(user);
        }
        return onlineUsers;
    }

}
