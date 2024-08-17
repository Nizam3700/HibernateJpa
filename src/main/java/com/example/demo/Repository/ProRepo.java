package com.example.demo.Repository;

import com.example.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProRepo extends JpaRepository<Project,Long> {
//    List<Project> findAllByProId(Long ProjectId);
    @Query("SELECT p FROM Project p WHERE p.projectId = :projectId")
    List<Project> findAllByProId(@Param("projectId") Long projectId);
}
