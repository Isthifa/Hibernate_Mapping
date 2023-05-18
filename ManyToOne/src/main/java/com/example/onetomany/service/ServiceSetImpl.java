package com.example.onetomany.service;

import com.example.onetomany.Repo.EmployeeRepo;
import com.example.onetomany.Repo.ProjectsRepo;
import com.example.onetomany.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSetImpl implements ServiceSet{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ProjectsRepo projectsRepo;
    @Override
    public List<Student> listall() {
        return employeeRepo.findAll();
    }

    @Override
    public Student save(Student student) {
        return employeeRepo.save(student);
    }


    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);

    }

    @Override
    public Student finbyid(int id) {
        return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


}
