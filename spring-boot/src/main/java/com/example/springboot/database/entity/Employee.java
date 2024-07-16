package com.example.springboot.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "office_id")
    private Integer officeId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "extension")
    private long extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private String reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours", columnDefinition = "DECIMAL")
    private Double vacationHours;

}

