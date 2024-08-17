package com.example.demo.Service;

import com.example.demo.Entity.Project;
import com.example.demo.Repository.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProService {

    @Autowired
    private ProRepo proRepo;

    public void saveProject(Project project){
        proRepo.save(project);
    }

    public List<Project> getProjectDetails(Long projectId){
        if(null != projectId){
            return proRepo.findAllByProId(projectId);
        }else{
            return proRepo.findAll();
        }
    }

    public void deleteProject(Long projectId){
        proRepo.deleteById(projectId);
    }
}
