package com.example.demo.Controller;

import com.example.demo.Entity.Project;
import com.example.demo.Service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProService proService;

    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project){
        proService.saveProject(project);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getProject","/{projectId}"})
    public List<Project> getProjects(@PathVariable(required = false) Long projectId){
        return proService.getProjectDetails(projectId);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity removeProject(@PathVariable Long projectId){
        proService.deleteProject(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
