package com.tractorental.fullstack_backend.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountDueRepository extends JpaRepository <AmountDue, Long>
{
    AmountDue findByFarmer_IdAndTractorOwner_Id(long farmerId, long tractorOwnerId);
}
