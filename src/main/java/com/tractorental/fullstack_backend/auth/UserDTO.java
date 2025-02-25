package com.tractorental.fullstack_backend.auth;


import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO
{
    private String username;
    private String email;
    private String password;
    private String role;
}