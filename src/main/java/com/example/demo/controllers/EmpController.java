package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmpService;
import com.example.demo.services.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmpController {

//    final EmpRepo empRepo;
//    public EmpController(EmpRepo empRepo) {
//        this.empRepo = empRepo;
//    }

    @Autowired
    EmpService empService;

    @GetMapping()
    public List<Employee> getAll() {
        return empService.findAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return empService.findEmployeeById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Employee employee) {
        empService.saveEmployee(employee);
    }
    @PostMapping("/updateVactions/{id}/{vacations}")
    public String updateVactions(@PathVariable Long id,@PathVariable Double vacations) {
        if(empService.takeVacations(id,vacations))
            return "true";
        else return "false";
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        empService.updateEmployee(employee.getId(), employee);
        return employee;
    }
}
