package jp.co.axa.apidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer salary;

    @Getter
    @Setter
    private String department;

    public ArrayList<String> validate(){
        ArrayList<String> validationErrors = new ArrayList<>();
        if(this.name==null || this.name.equals("")){
            validationErrors.add("Name can not be empty");
        }
        if(this.department==null || this.department.equals("")){
            validationErrors.add("Department can not be empty");
        }
        if(this.salary==null){
            validationErrors.add("Salary can not be empty");
        }
        return validationErrors;
    }
}
