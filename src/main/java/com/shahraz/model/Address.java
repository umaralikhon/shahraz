package com.shahraz.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String number;
    private String country;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address")
    private Visitor visitor;

}
