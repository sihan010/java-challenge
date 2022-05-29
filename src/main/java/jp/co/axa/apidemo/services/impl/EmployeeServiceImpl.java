package jp.co.axa.apidemo.services.impl;

import jp.co.axa.apidemo.dto.EmployeeDTO;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    @Cacheable(cacheNames = {"employeeCache"}, key = "#employeeId")
    public Optional<Employee> getEmployee(UUID employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public UUID saveEmployee(EmployeeDTO employeeDto) {
        // Map EmployeeDTO to Employee and save, ID auto generated
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getSalary(), employeeDto.getDepartment());
        Employee e = employeeRepository.save(employee);
        return e.getId();
    }

    @CacheEvict(cacheNames = {"employeeCache"}, key="#employeeId")
    public void deleteEmployee(UUID employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @CachePut(cacheNames = {"employeeCache"}, key="#employee.employeeId")
    public Employee updateEmployee(Employee employee, EmployeeDTO employeeDto) {
        // Map EmployeeDTO to Employee and save
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }
}