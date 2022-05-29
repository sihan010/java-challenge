package jp.co.axa.apidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    public ArrayList<String> validate(){
        ArrayList<String> validationErrors = new ArrayList<>();
        if(this.username==null || this.username.equals("")){
            validationErrors.add("Username can not be empty");
        }
        if(this.email==null || this.email.equals("")){
            validationErrors.add("Email can not be empty");
        }
        if(this.password==null || this.password.equals("")){
            validationErrors.add("Password can not be empty");
        }
        return validationErrors;
    }
}

