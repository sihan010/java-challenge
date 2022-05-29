package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.RegisterDTO;
import jp.co.axa.apidemo.entities.User;

public interface AuthService {
    User register(RegisterDTO register);
}
