package com.organisation.employee.data.repository;

import com.organisation.employee.data.entity.EmployeeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployeeEntity> getAllRecords() {
        TypedQuery<EmployeeEntity> query =
                entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class);
        List<EmployeeEntity> completeData = query.getResultList();
        return completeData;
    }

    @Override
    public EmployeeEntity findById(int id){
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
        return employee;
    }
    @Override
    public EmployeeEntity updateData(EmployeeEntity oldRecord){
        EmployeeEntity updatedRecord = entityManager.merge(oldRecord);
        return updatedRecord;
    }
    @Override
    public List<EmployeeEntity> updateMultipleData(String employeeDept){
        TypedQuery<EmployeeEntity> updateQuery = entityManager.createQuery("from EmployeeEntity where empDept = : conditionalData", EmployeeEntity.class);
        updateQuery.setParameter("conditionalData",employeeDept);
        return updateQuery.getResultList();
    }


    @Override
    public void createNewData(EmployeeEntity newEmployee){
        entityManager.merge(newEmployee);
        //entityManager.persist(newEmployee);
    }

    public void deleteById(int id){
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
        entityManager.remove(employee);
    }

}
