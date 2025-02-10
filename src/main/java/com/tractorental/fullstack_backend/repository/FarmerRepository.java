package com.tractorental.fullstack_backend.repository;

import com.tractorental.fullstack_backend.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository <Farmer,Integer> {
}
