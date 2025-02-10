package com.tractorental.fullstack_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "FARMER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "AGE")
    private int age;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LAND_AREA")
    private double landArea;

    @Column(name = "CROPS_GROWN")
    private String cropsGrown;

    @Column(name = "TRACTOR_OWNED")
    private boolean tractorOwned;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "AADHAR_NUMBER")
    private String aadharNumber;

    @Column(name = "PAYMENT_DUE")
    private double paymentDue;
}
