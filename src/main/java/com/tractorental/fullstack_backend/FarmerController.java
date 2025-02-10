package com.tractorental.fullstack_backend;

import com.tractorental.fullstack_backend.entity.Farmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
@CrossOrigin
public class FarmerController {

    @Autowired
    private FarmerService service;

    @GetMapping
    ResponseEntity<List<Farmer>> getFarmers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getFarmerDetails());
    }

    @PostMapping("/create")
    ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveFarmerDetails(farmer));
    }
}
