package by.tms.spring.repository;

import by.tms.spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository("userRepository")
public class CalcUserRepository implements UserRepository {

    private final List<User> users;
    private AtomicLong lastId;

    public CalcUserRepository(List<User> users) {
        this.users = users;
        this.lastId = new AtomicLong(0);
    }

    @Override
    public void add(User user) {
        user.setId(lastId.addAndGet(1));
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
    public User findById(long id) {
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
