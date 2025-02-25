package com.tractorental.fullstack_backend.profile;

import com.tractorental.fullstack_backend.auth.User;
import com.tractorental.fullstack_backend.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserDetailsService
{
    @Autowired
    private UserRepository repository;

    public UserDetailsDTO getUserDetails(long userId)
    {
        User user = repository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));
        return userDetailsTransformer(user);
    }

    private UserDetailsDTO userDetailsTransformer(User user)
    {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(user.getId());
        userDetailsDTO.setUsername(user.getUsername());
        userDetailsDTO.setEmail(user.getEmail());
        userDetailsDTO.setRoleName(user.getRole().getRoleName());

        if (user.getUserDetails() != null)
        {
            userDetailsDTO.setFullName(user.getUserDetails().getFullName());
            userDetailsDTO.setPhoneNumber(user.getUserDetails().getPhoneNumber());
            userDetailsDTO.setAddress(user.getUserDetails().getAddress());

            if (user.getRole().getRoleName().equals("Farmer"))
            {
                FarmerDetailsDTO farmerDetailsDTO = new FarmerDetailsDTO();
                farmerDetailsDTO.setLandOwned(user.getUserDetails().getFarmerDetails().getLandOwned());
                farmerDetailsDTO.setWaterSource(user.getUserDetails().getFarmerDetails().getWaterSource());
                farmerDetailsDTO.setCropType(user.getUserDetails().getFarmerDetails().getCropType());

                userDetailsDTO.setFarmerDetails(farmerDetailsDTO);
                userDetailsDTO.setTractorOwnerDetails(null);
            }
            else if (user.getRole().getRoleName().equals("Tractor Owner"))
            {
                TractorOwnerDetailsDTO tractorOwnerDetailsDTO = new TractorOwnerDetailsDTO();
                tractorOwnerDetailsDTO.setTractorCount(user.getUserDetails().getTractorOwnerDetails().getTractorCount());
                tractorOwnerDetailsDTO.setAvailabilityStatus(user.getUserDetails().getTractorOwnerDetails().isAvailabilityStatus());
                tractorOwnerDetailsDTO.setTractorModels(user.getUserDetails().getTractorOwnerDetails().getTractorModels());
                tractorOwnerDetailsDTO.setRentalPricePerHour(user.getUserDetails().getTractorOwnerDetails().getRentalPricePerHour());

                userDetailsDTO.setTractorOwnerDetails(tractorOwnerDetailsDTO);
                userDetailsDTO.setFarmerDetails(null);
            }
        }

        return userDetailsDTO;
    }

    public UserDetailsDTO updateUserDetails(long userId, UserDetailsDTO userDetailsDTO)
    {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));

        UserDetails updatedUserDetails = user.getUserDetails();
        if (updatedUserDetails == null)
        {
            updatedUserDetails = new UserDetails();
            updatedUserDetails.setUser(user);
        }

        updatedUserDetails.setFullName(userDetailsDTO.getFullName());
        updatedUserDetails.setPhoneNumber(userDetailsDTO.getPhoneNumber());
        updatedUserDetails.setAddress(userDetailsDTO.getAddress());

        if ("Farmer".equals(userDetailsDTO.getRoleName()))
        {
            FarmerDetails farmerDetails = updatedUserDetails.getFarmerDetails();
            if (farmerDetails == null)
            {
                farmerDetails = new FarmerDetails();
                farmerDetails.setUserDetails(updatedUserDetails);
            }
            farmerDetails.setLandOwned(userDetailsDTO.getFarmerDetails().getLandOwned());
            farmerDetails.setCropType(userDetailsDTO.getFarmerDetails().getCropType());
            farmerDetails.setWaterSource(userDetailsDTO.getFarmerDetails().getWaterSource());
            updatedUserDetails.setFarmerDetails(farmerDetails);
        }
        else if ("Tractor Owner".equals(userDetailsDTO.getRoleName()))
        {
            TractorOwnerDetails tractorOwnerDetails = updatedUserDetails.getTractorOwnerDetails();
            if (tractorOwnerDetails == null)
            {
                tractorOwnerDetails = new TractorOwnerDetails();
                tractorOwnerDetails.setUserDetails(updatedUserDetails);
            }
            tractorOwnerDetails.setTractorCount(userDetailsDTO.getTractorOwnerDetails().getTractorCount());
            tractorOwnerDetails.setTractorModels(userDetailsDTO.getTractorOwnerDetails().getTractorModels());
            tractorOwnerDetails.setRentalPricePerHour(userDetailsDTO.getTractorOwnerDetails().getRentalPricePerHour());
            updatedUserDetails.setTractorOwnerDetails(tractorOwnerDetails);
        }

        user.setUserDetails(updatedUserDetails);
        User updatedUser = repository.save(user);

        return userDetailsTransformer(updatedUser);
    }

}
