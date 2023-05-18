package com.example.onetomany.Repo;

import com.example.onetomany.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepo extends JpaRepository<Project,Integer> {
}
