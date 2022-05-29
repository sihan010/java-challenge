package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.EmployeeDTO;
import jp.co.axa.apidemo.entities.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> retrieveEmployees();

    Optional<Employee> getEmployee(UUID employeeId);

    UUID saveEmployee(EmployeeDTO employeeDto);

    void deleteEmployee(UUID employeeId);

    Employee updateEmployee(Employee employee, EmployeeDTO employeeDto);
}