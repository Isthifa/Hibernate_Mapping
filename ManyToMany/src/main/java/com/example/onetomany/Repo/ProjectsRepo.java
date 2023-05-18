package com.example.onetomany.Repo;

import com.example.onetomany.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepo extends JpaRepository<Projects,Integer> {
}
