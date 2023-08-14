package com.example.employee_v2.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee_v2")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_name;
    private String type_of_document;
    private String document_number;
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    @Temporal(TemporalType.DATE)
    private Date date_of_linkage;
    private String position;
    private Double salary;
}
