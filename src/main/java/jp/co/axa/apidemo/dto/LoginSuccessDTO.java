package jp.co.axa.apidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginSuccessDTO {
    @Getter
    @Setter
    private String token;
}

