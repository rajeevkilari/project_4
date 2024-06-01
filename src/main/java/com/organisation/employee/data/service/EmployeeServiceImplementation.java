package com.organisation.employee.data.service;

import com.organisation.employee.data.entity.EmployeeEntity;
import com.organisation.employee.data.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImplementation(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeEntity> getAllData(){
        return employeeDAO.getAllRecords();
    }

    @Override
    public EmployeeEntity getById(int id){
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public EmployeeEntity updateRecord(EmployeeEntity oldRecord){
        return employeeDAO.updateData(oldRecord);
    }

    @Transactional
    @Override
    public void deleteByEmpId(int id){
        employeeDAO.deleteById(id);
    }
    @Transactional
    @Override
    public void createRecord(EmployeeEntity newEmployee){
        employeeDAO.createNewData(newEmployee);
    }

    @Transactional
    @Override
    public List<EmployeeEntity> updateMultipleRecords(String employeeDept){
     List<EmployeeEntity> updatedMultiData =  employeeDAO.updateMultipleData(employeeDept);
     for(EmployeeEntity eachEmployee : updatedMultiData){
         eachEmployee.setEmpDept("IT");
         employeeDAO.updateData(eachEmployee);
     }
     return updatedMultiData;
    }


}
