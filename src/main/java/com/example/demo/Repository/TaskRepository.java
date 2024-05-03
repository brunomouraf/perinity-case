package com.example.demo.Repository;

import com.example.demo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(int id);
    List<Task> findByPersonId(int id);
}
