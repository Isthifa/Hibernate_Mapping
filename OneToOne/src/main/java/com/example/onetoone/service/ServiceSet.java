package com.example.onetoone.service;

import com.example.onetoone.entity.Instructor;

import java.util.List;

public interface ServiceSet {
    List<Instructor> listall();
    Instructor save(Instructor instructor);
    void delete(int id);
    Instructor finbyid(int id);
}
