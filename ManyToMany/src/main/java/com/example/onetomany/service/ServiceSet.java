package com.example.onetomany.service;

import com.example.onetomany.entity.Employe;
import com.example.onetomany.entity.Projects;

import java.util.List;

public interface ServiceSet {
    List<Employe> listall();
    Employe save(Employe employe);
    void delete(int id);
    Employe finbyid(int id);
}
