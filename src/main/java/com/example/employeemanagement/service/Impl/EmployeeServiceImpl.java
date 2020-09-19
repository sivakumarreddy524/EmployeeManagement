package com.example.employeemanagement.service.Impl;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepo;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepo employeeRepo;


    @Override
    public void saveEmployees(List<Employee> employeeList) {

        for (Employee e : employeeList) {
            employeeRepo.save(e);
        }
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepo.findAllByFirstNameOrLastName(name, name);
    }

    public List<Employee> searchByNameUsingStream(String name) {
        return employeeRepo.findAll().stream().filter(e -> {
            return e.getFirstName().equalsIgnoreCase(name) || e.getLastName().equalsIgnoreCase(name);
        }).collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByAgeGreaterThan(int age) {
        List<Employee> employees = employeeRepo.findAll();
        List<Employee> empList = employees.stream().filter(e -> {
            return Period.between(Instant.ofEpochMilli(e.getDob().getTime()).atZone(ZoneId.systemDefault()).toLocalDate(),
                    LocalDate.now()).getYears() > age;
        }).collect(Collectors.toList());
        return empList;
    }

    @Override
    public List<Employee> searchByAgeLessThan(int age) {
        List<Employee> employees = employeeRepo.findAll();
        List<Employee> empList = employees.stream().filter(e -> {
            return Period.between(Instant.ofEpochMilli(e.getDob().getTime()).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears() < age;
        }).collect(Collectors.toList());
        return empList;
    }

    @Override
    public List<Employee> searchBySalaryGreaterThan(int salary) {
        return employeeRepo.findAllBySalaryGreaterThan(salary);
    }

    public List<Employee> searchBySalaryGreaterThanUsingStreams(int salary) {
        return employeeRepo.findAll().stream().filter(e -> {
            return e.getSalary() > salary;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchBySalaryLessThan(int salary) {
        return employeeRepo.findAllBySalaryLessThan(salary);
    }

    public List<Employee> searchBySalaryLessThanUsingStreams(int salary) {
        return employeeRepo.findAll().stream().filter(e -> {
            return e.getSalary() < salary;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByAddress(String address) {
        return employeeRepo.findAllByAddressContains(address);
    }

    @Override
    public List<Employee> searchByBloodGroup(String bloodGroup) {
        return employeeRepo.findAllByBloodGroup(bloodGroup);
    }

    @Override
    public void updateEmployee(Employee employee, long employeeId) {
        Optional<Employee> e = employeeRepo.findById(employeeId);
        if (e.isPresent()) {
            Employee ee = e.get();
            ee.setAddress(employee.getAddress());
            ee.setBloodGroup(employee.getBloodGroup());
            ee.setDesignation(employee.getDesignation());
            ee.setDob(employee.getDob());
            ee.setFirstName(employee.getFirstName());
            ee.setLastName(employee.getLastName());
            ee.setSalary(employee.getSalary());
            employeeRepo.save(ee);
        }

    }


}
