package jp.co.axa.apidemo.services.impl;

import jp.co.axa.apidemo.dto.RegisterDTO;
import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.repositories.UserRepository;
import jp.co.axa.apidemo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(RegisterDTO register) {
        String encodedPass = passwordEncoder.encode(register.getPassword()); // Hash Password
        User user = new User(register.getUsername(), register.getEmail(), encodedPass);
        return userRepository.save(user);
    }
}
