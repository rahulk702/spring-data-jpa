/*
 * Author
 * Rahul Kumar
 */

package com.spring.data.jpa.papractics.dao;

import com.spring.data.jpa.papractics.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee getEmployeeByFirstName(String empName);
}
