package com.tractorental.fullstack_backend;

import com.tractorental.fullstack_backend.entity.Farmer;
import com.tractorental.fullstack_backend.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository repository;

    public Farmer saveFarmerDetails(Farmer farmer)
    {
        return repository.save(farmer);
    }

    public List<Farmer> getFarmerDetails()
    {
        return repository.findAll();
    }
}
