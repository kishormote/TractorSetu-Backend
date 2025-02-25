package com.tractorental.fullstack_backend.profile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TRACTOR_OWNER_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class TractorOwnerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToOne(targetEntity = UserDetails.class)
    @JoinColumn(name = "USER_DETAILS_ID", referencedColumnName = "ID")
    @JsonBackReference
    private UserDetails userDetails;

    @Column(name = "TRACTOR_COUNT")
    private int tractorCount;

    @Column(name = "TRACTOR_MODELS")
    private String tractorModels;

    @Column(name = "RENTAL_PRICE_PER_HOUR")
    private double rentalPricePerHour;

    @Column(name = "AVAILABILITY_STATUS")
    private boolean availabilityStatus = true;
}

