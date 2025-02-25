package com.tractorental.fullstack_backend.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tractorental.fullstack_backend.auth.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @JsonIgnore
    private User user;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private FarmerDetails farmerDetails;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private TractorOwnerDetails tractorOwnerDetails;
}

