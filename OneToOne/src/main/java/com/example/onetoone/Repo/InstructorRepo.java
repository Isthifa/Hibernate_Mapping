package com.example.onetoone.Repo;

import com.example.onetoone.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
}
