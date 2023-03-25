package com.example.demo.services;

import com.example.demo.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmpService {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(Long id);
    void saveEmployee(Employee employee);
    Optional<Employee> updateEmployee(Long id, Employee updatedEmployee);
    Optional<Employee> deleteEmployee(Long id);
    boolean takeVacations(Long empId,double numOfDays);
}
