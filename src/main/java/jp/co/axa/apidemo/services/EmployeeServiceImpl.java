package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.dto.EmployeeDTO;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(UUID employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public UUID saveEmployee(EmployeeDTO employeeDto) {
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getSalary(), employeeDto.getDepartment());
        Employee e = employeeRepository.save(employee);
        return e.getId();
    }

    public void deleteEmployee(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployee(Employee employee, EmployeeDTO employeeDto) {
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }
}