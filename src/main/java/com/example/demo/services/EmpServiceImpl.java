package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmpRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    //    @Autowired
//    private EmpRepo empRepo;
    final EmpRepo empRepo;

    public EmpServiceImpl(EmpRepo empRepo) {
        this.empRepo = empRepo;
    }

    public List<Employee> findAllEmployees() {
        return empRepo.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return empRepo.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee) {
        System.out.println("here"+employee);
        empRepo.save(employee);
    }

    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = Optional.ofNullable(findEmployeeById(id));
        existingEmployee.ifPresent(e -> {
            e.setEmpName(updatedEmployee.getEmpName());
            e.setCardNumber(updatedEmployee.getCardNumber());
            empRepo.save(e);
        });
        return existingEmployee;
    }

    public Optional<Employee> deleteEmployee(Long id) {
        Optional<Employee> employeeToDelete = Optional.ofNullable(findEmployeeById(id));
        employeeToDelete.ifPresent(e -> empRepo.delete(e));
        return employeeToDelete;
    }

    @Override
    public boolean takeVacations(Long empId, double numOfDays) {
        Optional<Employee> existingEmployee = Optional.ofNullable(findEmployeeById(empId));
        if(existingEmployee.isPresent()&&numOfDays>0){
            Employee emp = existingEmployee.get();
            emp.setVacations(emp.getVacations()-numOfDays>0?emp.getVacations()-numOfDays:emp.getVacations());
            return true;
        }
        else return false;


//        existingEmployee.ifPresent(e -> {
//            Employee emp = existingEmployee.get();
//            if(numOfDays>0){
//                e.setVacations(emp.getVacations()-numOfDays>0?emp.getVacations()-numOfDays:emp.getVacations());
//            }
//            empRepo.save(e);
//        });
//        return false;
    }
}
