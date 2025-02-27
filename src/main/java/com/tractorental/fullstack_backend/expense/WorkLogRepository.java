package com.tractorental.fullstack_backend.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLogs, Long>
{
    List<WorkLogs> findByFarmer_Id(Long farmerId);

    List<WorkLogs> findByFarmer_IdAndTractorOwnerTask_TractorOwner_Id(Long farmerId, Long ownerId);
}

