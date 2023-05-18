package com.example.onetoone.service;

import com.example.onetoone.Repo.InstructorRepo;
import com.example.onetoone.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSetImpl implements ServiceSet{
    @Autowired
    private InstructorRepo instructorRepo;
    @Override
    public List<Instructor> listall() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public void delete(int id) {
        instructorRepo.deleteById(id);

    }

    @Override
    public Instructor finbyid(int id) {
        return instructorRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

}
