package com.organisation.employee.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    public int empID;
    @Column(name = "full_name")
    public String fullName;
    @Column(name = "age")
    public int empAge;
    @Column(name = "department")
    public String empDept;
    public EmployeeEntity(String fullName, int empAge, String empDept) {
        this.fullName = fullName;
        this.empAge = empAge;
        this.empDept = empDept;
    }
    public EmployeeEntity(){

    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }
}
