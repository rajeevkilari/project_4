package com.organisation.employee.data.controller;

import com.organisation.employee.data.entity.EmployeeEntity;
import com.organisation.employee.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    public EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/list")
    public String getAllEmployees(Model theModel) {
        List<EmployeeEntity> employeeList = employeeService.getAllData();
        theModel.addAttribute("employees",employeeList);
        return "Employee-List";
    }

    @GetMapping("/DisplayForm")
    public String addEmployeeForm(Model theModel, EmployeeEntity newEmp){
        theModel.addAttribute("employee", newEmp);
        return "New-Employee-Entry";
    }

    @PostMapping("/SaveNewEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeEntity theEmployee){
        employeeService.createRecord(theEmployee);
        return "redirect:/list";
    }

    @GetMapping("/UpdateForm")
    public String updateEmployee(@RequestParam("employeeId") int empId, Model theModel){
        EmployeeEntity duplicateEmployee= employeeService.getById(empId);
        theModel.addAttribute("employee",duplicateEmployee );
        return "New-Employee-Entry";
    }

    @GetMapping("/DeleteData")
    public String deleteEmployee(@RequestParam("employeeId") int empId){
        employeeService.deleteByEmpId(empId);
        return "redirect:/list";
    }


}
