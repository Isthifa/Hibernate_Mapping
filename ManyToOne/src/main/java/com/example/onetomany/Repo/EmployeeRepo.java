package com.example.onetomany.Repo;

import com.example.onetomany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Student,Integer> {
}
