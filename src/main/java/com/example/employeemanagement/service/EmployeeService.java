package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeService {
    void saveEmployees(List<Employee> employeeList);

    List<Employee> searchByName(String name);

    List<Employee> searchByAgeGreaterThan(int age);

    List<Employee> searchByAgeLessThan(int age);

    List<Employee> searchBySalaryGreaterThan(int salary);

    List<Employee> searchBySalaryLessThan(int salary);

    List<Employee> searchByAddress(String address);

    @Query("select e from Employee e where e.bloodGroup=:bloodGroup")
    List<Employee> searchByBloodGroup(String bloodGroup);
}
