package com.example.employee_v2.controller;

import com.example.employee_v2.entity.Employee;
import com.example.employee_v2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.time.Period;
import java.time.LocalDate;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/employees")
@Validated
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

    // Cread
    @PostMapping
    public ResponseEntity<Employee> saveUpdate(@Valid @RequestBody Employee employee){
        Date edad = employee.getDate_of_birth();
        LocalDate edadLocal = edad.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period tiempo = Period.between(edadLocal, currentDate);
        if (tiempo.getYears() <= 18){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(employee);
        }
        Employee employeeBase = employeeService.saveOrUpdate(employee);
        if (employeeBase.getDate_of_birth()!= null) {
            LocalDate birthDate = employeeBase.getDate_of_birth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(birthDate, LocalDate.now());
            String formattedPeriod = String.format(
                    "%d years, %d months, %d days",
                    period.getYears(), period.getMonths(), period.getDays()
            );
            employeeBase.setAge(formattedPeriod);
        }
        if (employeeBase.getDate_of_linkage() != null) {
            LocalDate linkageDate = employeeBase.getDate_of_linkage().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period vinculationPeriod = Period.between(linkageDate, LocalDate.now());
            String formattedVinculation = String.format(
                    "%d years, %d months",
                    vinculationPeriod.getYears(), vinculationPeriod.getMonths()
            );
            employeeBase.setVinculationTime(formattedVinculation);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeBase);
    }

    //Delete by ID
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> delete(@PathVariable("employeeId") Long employeeId){
        employeeService.delete(employeeId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Delete");
    }
}
