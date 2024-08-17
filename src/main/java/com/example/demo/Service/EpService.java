package com.example.demo.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Project;
import com.example.demo.Repository.EpRepo;
import com.example.demo.Repository.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EpService {

    @Autowired
    private EpRepo epRepo;

    @Autowired
    private ProRepo proRepo;

    public void saveEp(Employee employee){
        epRepo.save(employee);
    }

    public List<Employee> getEmployeeDetails(Long epId){
        if(null != epId){
            return epRepo.findAllByEmpId(epId);
        }else{
            return epRepo.findAll();
        }
    }

    @GetMapping
    public List<Employee> getAllEmp(){

        return epRepo.findAll();
    }

    public void DeleteEmployee(Long epId){
        epRepo.deleteById(epId);
    }

    public Employee assignProject(Long empId, Long projectId) {
        List<Project> projectList = null;
        Employee employee = epRepo.findById(empId).get();
        Project project = proRepo.findById(projectId).get();
        projectList = employee.getProject();
        projectList.add(project);

        employee.setProject(projectList);
        return epRepo.save(employee);
    }
}
