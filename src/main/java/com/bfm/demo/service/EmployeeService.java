package com.bfm.demo.service;

import com.bfm.demo.Exceptionalhandling.BusinessException;
import com.bfm.demo.Exceptionalhandling.EmptyInputException;
import com.bfm.demo.entity.Employee;
import com.bfm.demo.repository.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    EmployeeCrudRepo crudRepo;

    @Override
    public Employee addEmployee(Employee emp) {
        if(emp.getName() != null || emp.getName().length() !=0){
            throw new EmptyInputException("601","Please enter name");
        }
        try {
            return crudRepo.save(emp);
        }catch(BusinessException e){
            throw new BusinessException("602","Some error occured");
        }catch(Exception e){
            throw new BusinessException("603","Some error occured in service class"+e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empList = null;
        try {
            empList = crudRepo.findAll();
        }
        catch (Exception e) {
            throw new BusinessException("605","Something went wrong in Service layer while fetching all employees" + e.getMessage());
        }
        if(empList.isEmpty())
            throw new BusinessException("604", "Hey list completely empty, we have nothing to return");
        return empList;
    }

    @Override
    public Employee getEmpById(Long empidL) {
            return crudRepo.findById(empidL).get();
    }

    @Override
    public void deleteEmployeeById(Long empidL) {
        try {
            crudRepo.deleteById(empidL);
        }catch (IllegalArgumentException e) {
            throw new BusinessException("608","given employee id is null, please send some id to be deleted" + e.getMessage());
        }catch (Exception e) {
            throw new BusinessException("610","Something went wrong in Service layer while fetching all employees" + e.getMessage());
        }
    }

    @Override
    public Employee updateEmployeeById(Long id, String name) {
        Employee e = crudRepo.findById(id).get();
        e.setName(name);
        return crudRepo.saveAndFlush(e);
    }
}
