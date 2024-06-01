package com.organisation.employee.data.service;

import com.organisation.employee.data.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeEntity> getAllData();
    public EmployeeEntity getById(int id);
    public EmployeeEntity updateRecord(EmployeeEntity oldRecord);
    public void deleteByEmpId(int id);
    public void createRecord(EmployeeEntity newEmployee);
    public List<EmployeeEntity> updateMultipleRecords(String employeeDept);
}
