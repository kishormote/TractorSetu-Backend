package com.tractorental.fullstack_backend.expense;

import com.tractorental.fullstack_backend.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TractorOwnerTaskRepository extends JpaRepository<TractorOwnerTask, Long>
{
    List<TractorOwnerTask> findByTractorOwner(User owner);

    Optional<TractorOwnerTask> findByTractorOwnerAndTaskName(User owner, String taskName);
}
