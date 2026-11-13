/*
 * Author
 * Rahul Kumar
 */

package com.spring.data.jpa.papractics.controller;

import com.spring.data.jpa.papractics.entity.Employee;
import com.spring.data.jpa.papractics.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/spring-data-jpa")
public class EmployeeController {

    private final EmployeeService employeeService;

    // constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmployeeByName")
    public Employee getEmployeeByFirstName(@RequestParam(value = "empName") String empName) {
        return employeeService.getEmployeeByFirstName(empName);
    }

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeByFirstName(@RequestParam(value = "empId") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
       return employeeService.addEmployee(employee);
    }

    @PutMapping("/updateEmployee/{empId}")
    public Employee updateEmployee(@PathVariable(value = "empId") Long empId,
                                    @RequestBody Employee employee) {

       return employeeService.updateEmployee(empId , employee);
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public String deleteEmployee(@PathVariable(value = "empId") Long empId) {
       return employeeService.deleteEmployee(empId);
    }
    // Patch means partially update if you want to update only some fields then use PatchMapping
    @PatchMapping("/patchEmployee/{empId}")
    public Employee partiallyUpdateEmployee(
            @PathVariable Long empId,
            @RequestBody Employee employee) {
        return employeeService.partiallyUpdateEmployee(empId, employee);
    }


}
