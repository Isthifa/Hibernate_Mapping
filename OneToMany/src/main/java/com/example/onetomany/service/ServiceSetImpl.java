package com.example.onetomany.service;

import com.example.onetomany.Repo.EmployeeRepo;
import com.example.onetomany.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSetImpl implements ServiceSet{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<Employee> listall() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);

    }

    @Override
    public Employee finbyid(int id) {
        return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


}
