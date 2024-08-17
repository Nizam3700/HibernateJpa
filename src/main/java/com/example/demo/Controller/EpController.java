package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Employeee;
import com.example.demo.Service.EpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EpController {

    @Autowired
    private EpService epService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        epService.saveEp(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getEmployees", "/{epId}"})
    public List<Employee> getEmployee(@PathVariable(required = false) Long epId){
        return epService.getEmployeeDetails(epId);
    }

    @DeleteMapping("delete/{epId}")
    public ResponseEntity removeEmployee(@PathVariable Long epId){
        epService.DeleteEmployee(epId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{empId}/project/{projectId}")
    public Employee assignProject(
            @PathVariable Long empId,
            @PathVariable Long projectId){
        return epService.assignProject(empId,projectId);
    }


}
