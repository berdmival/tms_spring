package by.tms.spring.service;

import by.tms.spring.model.AuthData;
import by.tms.spring.model.User;
import by.tms.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class CalcUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public CalcUserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            userRepository.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null && !user.isLogin()) {
            user.login();
            return user;
        } else return null;
    }

    @Override
    public User logout(int id) {
        User user = userRepository.findById(id);
        if (user != null) user.logout();
        return user;
    }

    @Override
    public List<User> findOnlineUsers() {
        return userRepository.findOnline();
    }

    @Override
    public User login(AuthData authData) {
        User user = userRepository.findByEmailAndPassword(authData.getEmail(), authData.getPassword());
        if (user != null && !user.isLogin()) {
            user.login();
            return user;
        } else return null;
    }

}
