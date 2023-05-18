package com.example.onetomany.service;

import com.example.onetomany.entity.Student;

import java.util.List;

public interface ServiceSet {
    List<Student> listall();
    Student save(Student student);
    void delete(int id);
    Student finbyid(int id);
}
