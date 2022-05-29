package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.dto.EmployeeDTO;
import jp.co.axa.apidemo.dto.ValidationErrorsDTO;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.utilities.HeaderUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public ResponseEntity getEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return new ResponseEntity(employees, HeaderUtilities.commonHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity getEmployee(@PathVariable(name = "employeeId") UUID employeeId) {
        Optional<Employee> optionalEmployee = employeeService.getEmployee(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return new ResponseEntity(employee, HeaderUtilities.commonHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDto) {
        ArrayList<String> validationErrors = employeeDto.validate();
        if (validationErrors.size() > 0) {
            return new ResponseEntity(new ValidationErrorsDTO(validationErrors), HttpStatus.BAD_REQUEST);
        }
        UUID id = employeeService.saveEmployee(employeeDto);
        logger.info("Employee Saved Successfully");
        return new ResponseEntity(HeaderUtilities.createdHeaders("/api/v1/employees/" + id.toString()), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "employeeId") UUID employeeId) {
        Optional<Employee> optionalEmployee = employeeService.getEmployee(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employeeService.deleteEmployee(employee.getId());
            logger.info("Employee Deleted Successfully");
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDto,
                                         @PathVariable(name = "employeeId") UUID employeeId) {
        ArrayList<String> validationErrors = employeeDto.validate();
        if (validationErrors.size() > 0) {
            return new ResponseEntity(new ValidationErrorsDTO(validationErrors), HeaderUtilities.commonHeaders(), HttpStatus.BAD_REQUEST);
        }

        Optional<Employee> optionalEmployee = employeeService.getEmployee(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Employee updatedEmployee = employeeService.updateEmployee(employee, employeeDto);
            logger.info("Employee Deleted Successfully");
            return new ResponseEntity(updatedEmployee, HeaderUtilities.commonHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
