package com.example.onetomany.controller;

import com.example.onetomany.Repo.ProjectsRepo;
import com.example.onetomany.entity.Employe;
import com.example.onetomany.entity.Projects;
import com.example.onetomany.service.ServiceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private ServiceSet serviceSet;
    @Autowired
    private ProjectsRepo projectsRepo;

    @GetMapping("/list")
    public List<Employe> listall()
    {
        return serviceSet.listall();
    }
    @PostMapping("/save")
    public Employe save(@RequestBody Employe employe)
    {
        return serviceSet.save(employe);
    }

    @PostMapping("/c/save")
    public Projects save(@RequestBody Projects projects)
    {
        return projectsRepo.save(projects);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employe> byid(@PathVariable int id)
    {
        Employe employe =serviceSet.finbyid(id);
        return new ResponseEntity<>(employe,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Employe employe = serviceSet.finbyid(id);
        if (employe == null) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        } else {

            serviceSet.delete(id);
            return new ResponseEntity<>("Deleted from DB, details=>\n" + employe, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Employe employe)
    {
        Employe employe1 =serviceSet.finbyid(id);
        employe1.setFirstName(employe.getFirstName());
        employe1.setLastName(employe.getLastName());
        employe1.setEmail(employe.getEmail());
        serviceSet.save(employe);
        return new ResponseEntity<>(employe,HttpStatus.ACCEPTED);
    }
}
