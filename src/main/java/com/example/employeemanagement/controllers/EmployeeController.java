package com.example.employeemanagement.controllers;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployees")
    public ResponseEntity<?> saveEmployees(@Validated @RequestBody List<Employee> employeeList) {
        HashMap<String, Object> map = new HashMap<>();
        employeeService.saveEmployees(employeeList);
        map.put("status", "OK");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/searchByFirstNameOrLastName")
    public ResponseEntity<List<Employee>> searchByName(@RequestParam String name) {
        List<Employee> employees = employeeService.searchByName(name);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchByAgeGreaterThan")
    public ResponseEntity<List<Employee>> searchByAgeGreaterThan(@RequestParam int age) {
        List<Employee> employees = employeeService.searchByAgeGreaterThan(age);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchByAgeLessThan")
    public ResponseEntity<List<Employee>> searchByAgeLessThan(@RequestParam int age) {
        List<Employee> employees = employeeService.searchByAgeLessThan(age);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchBySalaryGreaterThan")
    public ResponseEntity<List<Employee>> searchBySalaryGreaterThan(@RequestParam int salary) {
        List<Employee> employees = employeeService.searchBySalaryGreaterThan(salary);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchBySalaryLessThan")
    public ResponseEntity<List<Employee>> searchBySalaryLessThan(@RequestParam int salary) {
        List<Employee> employees = employeeService.searchBySalaryLessThan(salary);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchByAddress")
    public ResponseEntity<List<Employee>> searchByAddress(@RequestParam String address) {
        List<Employee> employees = employeeService.searchByAddress(address);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchByBloodGroup")
    public ResponseEntity<List<Employee>> searchByBloodGroup(@RequestParam String bloodGroup) {
        List<Employee> employees = employeeService.searchByBloodGroup(bloodGroup);
        return ResponseEntity.ok(employees);
    }

}
