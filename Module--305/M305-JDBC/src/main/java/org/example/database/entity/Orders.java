package org.example.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "orders")
public class Orders {

    @Id //this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is telling hibernate that the PK is auto increment
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id")
    private Integer cutomerId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "shipped_date")
    private String shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;



}
