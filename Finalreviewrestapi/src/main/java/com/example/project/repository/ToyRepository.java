package com.example.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Toy;

public interface ToyRepository extends JpaRepository<Toy, Long> {
}