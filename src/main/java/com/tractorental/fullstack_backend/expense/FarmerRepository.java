package com.tractorental.fullstack_backend.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerRepository extends JpaRepository<Farmers, Long>, JpaSpecificationExecutor<Farmers>
{
    @Query("SELECT DISTINCT w.farmer FROM WorkLogs w WHERE w.tractorOwnerTask.tractorOwner.id = :ownerId")
    List<Farmers> findFarmersByTractorOwner(@Param("ownerId") Long ownerId);
}
