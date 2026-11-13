/*
 * Author
 * Rahul Kumar
 */

package com.spring.data.jpa.papractics.service;

import com.spring.data.jpa.papractics.dao.EmployeeRepository;
import com.spring.data.jpa.papractics.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
       return employeeRepository.findAll();
    }

    public Employee getEmployeeByFirstName(String empName) {
        return employeeRepository.getEmployeeByFirstName(empName);
    }

    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).
                orElseThrow(() -> new RuntimeException(" Employee Not found : "+ empId));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long empId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found : " + empId));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());
        existingEmployee.setSex(employee.getSex());
        return employeeRepository.save(existingEmployee);
    }

    public String deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
        return "Employee deleted successfully with Id : " + empId;
    }

    public Employee partiallyUpdateEmployee(Long empId, Employee updates) {
        Employee existing = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found : " + empId));

        if (updates.getFirstName() != null) {
            existing.setFirstName(updates.getFirstName());
        }
        if (updates.getLastName() != null) {
            existing.setLastName(updates.getLastName());
        }
        if (updates.getEmailId() != null) {
            existing.setEmailId(updates.getEmailId());
        }
        if (updates.getSex() != null) {
            existing.setSex(updates.getSex());
        }

        return employeeRepository.save(existing);
    }
}
