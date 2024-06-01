package com.organisation.employee.data.repository;

import com.organisation.employee.data.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    public List<EmployeeEntity> getAllRecords();
    public EmployeeEntity findById(int id);
    public void createNewData(EmployeeEntity employee);
    public void deleteById(int id);
    public EmployeeEntity updateData(EmployeeEntity modifiedRecord);

    public List<EmployeeEntity> updateMultipleData(String employeeDept);

}
