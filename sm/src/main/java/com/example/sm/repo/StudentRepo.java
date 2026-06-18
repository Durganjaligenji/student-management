package com.example.sm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sm.entity.Students;

public interface StudentRepo extends JpaRepository<Students, Long>{

}
