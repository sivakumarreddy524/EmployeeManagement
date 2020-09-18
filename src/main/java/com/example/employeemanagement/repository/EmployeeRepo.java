package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findAllByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findAllBySalaryGreaterThan(int salary);

    List<Employee> findAllBySalaryLessThan(int salary);

    List<Employee> findAllByAddressContains(String address);

    List<Employee> findAllByBloodGroup(String booldGroup);
}
