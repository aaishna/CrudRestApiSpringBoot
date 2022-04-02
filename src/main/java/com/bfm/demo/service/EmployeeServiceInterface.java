package com.bfm.demo.service;

import com.bfm.demo.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee addEmployee(Employee emp);

    List<Employee> getAllEmployee();

    Employee getEmpById(Long id);

    void deleteEmployeeById(Long id);

    Employee updateEmployeeById(Long id, String name);
}
