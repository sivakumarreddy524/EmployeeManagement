package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;


import java.util.List;

public interface EmployeeService {
    void saveEmployees(List<Employee> employeeList);

    List<Employee> searchByName(String name);

    List<Employee> searchByAgeGreaterThan(int age);

    List<Employee> searchByAgeLessThan(int age);

    List<Employee> searchBySalaryGreaterThan(int salary);

    List<Employee> searchBySalaryLessThan(int salary);

    List<Employee> searchByAddress(String address);

    List<Employee> searchByBloodGroup(String bloodGroup);

    void updateEmployee(Employee employee, long employeeId);
}
