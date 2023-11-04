package com.example.EffectiveDataTransfer.Repository;

import com.example.EffectiveDataTransfer.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
