package com.example.demo.Repository;

import com.example.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpRepo extends JpaRepository<Employee,Long> {
//    List<Employee> findAllByEmpId(Long epId);
    @Query("SELECT e FROM Employee e WHERE e.empId = :empId")
    List<Employee> findAllByEmpId(@Param("empId") Long empId);
}
