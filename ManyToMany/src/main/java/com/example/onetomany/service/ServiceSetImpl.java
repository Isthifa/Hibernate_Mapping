package com.example.onetomany.service;

import com.example.onetomany.Repo.EmployeeRepo;
import com.example.onetomany.Repo.ProjectsRepo;
import com.example.onetomany.entity.Employe;
import com.example.onetomany.entity.Projects;
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
    public List<Employe> listall() {
        return employeeRepo.findAll();
    }

    @Override
    public Employe save(Employe employe) {
        return employeeRepo.save(employe);
    }


    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);

    }

    @Override
    public Employe finbyid(int id) {
        return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


}
