package com.example.demo.repository;

import com.example.demo.entities.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentReactiveRepository extends ReactiveCrudRepository<Student,String> {
}