package com.example.onetoone.controller;

import com.example.onetoone.entity.Instructor;
import com.example.onetoone.entity.Instructordetails;
import com.example.onetoone.service.ServiceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructController {
    @Autowired
    private ServiceSet serviceSet;

    @GetMapping("/list")
    public List<Instructor> listall()
    {
        return serviceSet.listall();
    }
    @PostMapping("/save")
    public Instructor save(@RequestBody Instructor instructor)
    {
        return serviceSet.save(instructor);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> byid(@PathVariable int id)
    {
        Instructor instructors=serviceSet.finbyid(id);
        return new ResponseEntity<>(instructors,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Instructor instructor = serviceSet.finbyid(id);
        if (instructor == null) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        } else {

            serviceSet.delete(id);
            return new ResponseEntity<>("Deleted from DB, details=>\n" + instructor, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Instructor instructor)
    {
        Instructor instructor1=serviceSet.finbyid(id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setInstructordetails(instructor.getInstructordetails());

        Instructordetails instructordetails=instructor.getInstructordetails();
        instructordetails.setYoutubeChannel(instructordetails.getYoutubeChannel());
        instructordetails.setHobby(instructordetails.getHobby());
        serviceSet.save(instructor1);
        return new ResponseEntity<>(instructor1,HttpStatus.ACCEPTED);
    }
}
