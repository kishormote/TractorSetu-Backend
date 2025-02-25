package com.tractorental.fullstack_backend.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role findByRoleName(String roleName)
    {
        return roleRepository.findByRoleName(roleName);
    }
}
