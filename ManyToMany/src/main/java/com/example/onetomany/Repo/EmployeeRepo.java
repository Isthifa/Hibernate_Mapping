package com.example.onetomany.Repo;

import com.example.onetomany.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employe,Integer> {
}
