package com.example.employee_v2.controller;

import com.example.employee_v2.entity.Employee;
import com.example.employee_v2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Consult all
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getEmployees();
    }
    //Consult by ID
    @GetMapping("/{employeeId}")
    public Optional<Employee> getById(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Employee employee){

        employeeService.saveOrUpdate(employee);
    }

    //Delete by ID
    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable("employeeId") Long employeeId){

        employeeService.delete(employeeId);
    }
}
