package com.example.onetomany.controller;

import com.example.onetomany.Repo.EmployeeRepo;
import com.example.onetomany.entity.Address;
import com.example.onetomany.entity.Employee;
import com.example.onetomany.service.ServiceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private ServiceSet serviceSet;

    @GetMapping("/list")
    public List<Employee> listall()
    {
        return serviceSet.listall();
    }
    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee)
    {
        return serviceSet.save(employee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> byid(@PathVariable int id)
    {
        Employee employee=serviceSet.finbyid(id);
        return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Employee employee = serviceSet.finbyid(id);
        if (employee == null) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        } else {

            serviceSet.delete(id);
            return new ResponseEntity<>("Deleted from DB, details=>\n" + employee, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Employee employee)
    {
        Employee employee1=serviceSet.finbyid(id);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setAddress(employee.getAddress());

        List<Address> addresses=employee.getAddress();
        addresses.set(0,addresses.get(0));
        addresses.set(1,addresses.get(1));
        serviceSet.save(employee);
        return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
}
