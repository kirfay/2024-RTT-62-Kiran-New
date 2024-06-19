package org.example.database.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "customers")

public class Customers {

    @Id //this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is telling hibernate that the PK is auto increment
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String customerlastname;

    @Column(name = "contact_firstname")
    private String customerfirstname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalcode;

    @Column(name = "country")
    private String country;

    @Column(name = "sales_rep_employee_id")
    private Integer salesRepEmployeeId;

    @Column(name = "credit_limit")
    private Integer creditlimit;


}
