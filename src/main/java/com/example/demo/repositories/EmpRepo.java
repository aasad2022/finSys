package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee, Long> {
}
