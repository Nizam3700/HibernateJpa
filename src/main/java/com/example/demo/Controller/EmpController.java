package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmpRepo;
import com.example.demo.Entity.Employeee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/employee")
public class EmpController {

    @Autowired
    private EmpRepo empRepo;

    @PostMapping
    public ResponseEntity<String> saveEmp(@RequestBody List<Employeee> employeeeList){
        empRepo.saveAll(employeeeList);
        return ResponseEntity.ok("Data Saved in DataBase");
    }

    // GET API to retrieve an employee by ID
    @GetMapping("/{empId}")
    public ResponseEntity<Employeee> getEmp(@PathVariable Long empId){
        Optional<Employeee> employeee = empRepo.findById(empId);
        return employeee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET API to retrieve all employees


}
