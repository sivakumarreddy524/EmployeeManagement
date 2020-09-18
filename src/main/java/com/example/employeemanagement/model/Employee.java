package com.example.employeemanagement.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dob;

    @NotNull
    @Column(nullable = false)
    private String designation;

    @NotNull
    @Column(nullable = false)
    private int salary;

    @Column
    private String address;

    @Column
    private String bloodGroup;

}
