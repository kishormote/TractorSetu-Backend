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
    @Query(value = "SELECT F.ID AS id, F.NAME AS name, E.AMOUNT_DUE AS amountDue, " +
                   "(SELECT MAX(L.TASK_DATE) " +
                   " FROM WORK_LOGS L " +
                   " JOIN TRACTOR_OWNER_TASKS T ON L.TRACTOR_OWNER_TASK_ID = T.ID " +
                   " WHERE T.TRACTOR_OWNER_ID = :tractorOwnerId) AS lastWorkDate " +
                   "FROM FARMERS F " +
                   "JOIN AMOUNT_DUE E ON F.ID = E.FARMER_ID " +
                   "WHERE E.TRACTOR_OWNER_ID = :tractorOwnerId",
            nativeQuery = true)
    List<FarmersDueResponse> findFarmersByTractorOwner(@Param("tractorOwnerId") Long ownerId);
}
