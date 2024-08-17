package com.example.demo.Repository;

import com.example.demo.Entity.Employeee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employeee,Long> {
}
