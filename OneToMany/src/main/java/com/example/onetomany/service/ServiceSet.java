package com.example.onetomany.service;

import com.example.onetomany.entity.Employee;

import java.util.List;

public interface ServiceSet {
    List<Employee> listall();
    Employee save(Employee employee);
    void delete(int id);
    Employee finbyid(int id);
}
