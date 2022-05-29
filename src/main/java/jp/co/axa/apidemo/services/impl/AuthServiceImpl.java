package jp.co.axa.apidemo.services.impl;

import jp.co.axa.apidemo.dto.LoginDTO;
import jp.co.axa.apidemo.dto.RegisterDTO;
import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.repositories.UserRepository;
import jp.co.axa.apidemo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean login(LoginDTO login) {
        Optional<User> optionalUser = userRepository.findByUsername(login.getUsername());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            String encodedPass = passwordEncoder.encode(login.getPassword());
            return user.getPassword().equals(encodedPass);
        }
        else{
            return false;
        }
    }

    @Override
    public User register(RegisterDTO register) {
        String encodedPass = passwordEncoder.encode(register.getPassword());
        User user = new User(register.getUsername(), register.getEmail(), encodedPass);
        return userRepository.save(user);
    }
}
