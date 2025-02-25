package com.tractorental.fullstack_backend.profile;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmerDetailsDTO
{
    private double landOwned;
    private String cropType;
    private String waterSource;
}