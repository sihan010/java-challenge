package jp.co.axa.apidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
public class ValidationErrorsDTO {
    @Getter
    @Setter
    private ArrayList<String> messages;
}
