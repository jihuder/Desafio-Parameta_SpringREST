package com.example.employee_v2.service;
import org.springframework.stereotype.Service;

import com.example.employee_v2.entity.Employee;
import com.example.employee_v2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    //method read all
    public List<Employee> getEmployees(){

        return employeeRepository.findAll();
    }

    //method read
    public Optional<Employee> getEmployee(Long id){

        return employeeRepository.findById(id);
    }

    //method Save and Update
    public Employee saveOrUpdate(Employee employee){

        return employeeRepository.save(employee);
    }

    //method Delete
    public void delete(Long id){

        employeeRepository.deleteById(id);
    }
}
