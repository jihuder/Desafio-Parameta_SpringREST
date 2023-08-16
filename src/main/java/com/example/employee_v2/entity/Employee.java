package com.example.employee_v2.entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_v2")
@Validated
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "The last name cannot be empty")
    private String last_name;

    @NotBlank(message = "The document type cannot be empty")
    private String type_of_document;

    @NotBlank(message = "The document number cannot be empty")
    private String document_number;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date_of_linkage;

    @NotBlank(message = "The position cannot be empty")
    private String position;
    @NotNull(message = "The salary cannot be empty")
    private Double salary;
    @Transient
    private String vinculationTime;
    @Transient
    private String age;

    @PrePersist
    private void prePersist() {
        if (date_of_linkage == null) {
            date_of_linkage = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getType_of_document() {
        return type_of_document;
    }

    public void setType_of_document(String type_of_document) {
        this.type_of_document = type_of_document;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_linkage() {
        return date_of_linkage;
    }

    public void setDate_of_linkage(Date date_of_linkage) {
        this.date_of_linkage = date_of_linkage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getVinculationTime() {
        return vinculationTime;
    }

    public void setVinculationTime(String vinculationTime) {
        this.vinculationTime = vinculationTime;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
