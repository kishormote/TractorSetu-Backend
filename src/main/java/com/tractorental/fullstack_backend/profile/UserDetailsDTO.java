package com.tractorental.fullstack_backend.profile;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO
{
    private long id;
    private String username;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String roleName;
    private FarmerDetailsDTO farmerDetails;
    private TractorOwnerDetailsDTO tractorOwnerDetails;
}
