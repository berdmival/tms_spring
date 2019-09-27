package by.tms.spring.application.service;

import by.tms.spring.application.model.user.CalcUser;
import by.tms.spring.application.model.user.User;
import by.tms.spring.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class CalcUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public CalcUserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(User user) {
        if (userRepository.findByEmail(((CalcUser) user).getEmail()) == null) {
            userRepository.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(String email, String password) {
        CalcUser user = (CalcUser) userRepository.findByEmailAndPassword(email, password);
        if (user != null) user.login();
        return user;
    }

    @Override
    public User logout(int id) {
        CalcUser user = (CalcUser) userRepository.findById(id);
        if (user != null) user.logout();
        return user;
    }

}
