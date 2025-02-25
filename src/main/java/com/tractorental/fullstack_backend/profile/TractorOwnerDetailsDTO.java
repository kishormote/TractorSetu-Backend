package com.tractorental.fullstack_backend.profile;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TractorOwnerDetailsDTO
{
    private int tractorCount;
    private String tractorModels;
    private double rentalPricePerHour;
    private boolean availabilityStatus;
}