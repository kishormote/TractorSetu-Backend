package com.tractorental.fullstack_backend.profile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FARMER_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class FarmerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToOne(targetEntity = UserDetails.class)
    @JoinColumn(name = "USER_DETAILS_ID", referencedColumnName = "ID")
    @JsonBackReference
    private UserDetails userDetails;

    @Column(name = "LAND_OWNED")
    private double landOwned;

    @Column(name = "CROP_TYPE")
    private String cropType;

    @Column(name = "WATER_SOURCE")
    private String waterSource;
}

