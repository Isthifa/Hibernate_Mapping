package com.example.onetomany.controller;

import com.example.onetomany.Repo.ProjectsRepo;
import com.example.onetomany.entity.Student;
import com.example.onetomany.entity.Project;
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
    public List<Student> listall()
    {
        return serviceSet.listall();
    }
    @PostMapping("/save")
    public Student save(@RequestBody Student student)
    {
        return serviceSet.save(student);
    }

    @PostMapping("/c/save")
    public Project save(@RequestBody Project project)
    {
        return projectsRepo.save(project);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> byid(@PathVariable int id)
    {
        Student student =serviceSet.finbyid(id);
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Student student = serviceSet.finbyid(id);
        if (student == null) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        } else {

            serviceSet.delete(id);
            return new ResponseEntity<>("Deleted from DB, details=>\n" + student, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Student student)
    {
        Student student1 =serviceSet.finbyid(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        serviceSet.save(student);
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
    }
}
