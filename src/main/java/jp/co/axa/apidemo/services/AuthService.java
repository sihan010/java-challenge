package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.LoginDTO;
import jp.co.axa.apidemo.dto.RegisterDTO;
import jp.co.axa.apidemo.entities.User;

public interface AuthService {
    Boolean login(LoginDTO login);

    User register(RegisterDTO register);
}
