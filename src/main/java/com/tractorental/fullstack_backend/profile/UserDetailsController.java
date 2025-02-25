package com.tractorental.fullstack_backend.profile;

import com.tractorental.fullstack_backend.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile/userdetails")
@CrossOrigin(origins = "*")
public class UserDetailsController
{
    @Autowired
    private UserDetailsService service;

    @GetMapping("/{userId}")
    ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable long userId)
    {
        UserDetailsDTO userDetails = service.getUserDetails(userId);
        return ResponseEntity.ok(userDetails);
    }

    @PutMapping("/{userId}")
    ResponseEntity<UserDetailsDTO> updateUserDetails(@PathVariable long userId, @RequestBody UserDetailsDTO userDetails)
    {
        UserDetailsDTO updatedUserDetails = service.updateUserDetails(userId,userDetails);
        return ResponseEntity.ok(updatedUserDetails);
    }
}
