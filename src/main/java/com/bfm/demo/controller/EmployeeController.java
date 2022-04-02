package com.bfm.demo.controller;

import com.bfm.demo.Exceptionalhandling.BusinessException;
import com.bfm.demo.Exceptionalhandling.ControllerException;
import com.bfm.demo.entity.Employee;
import com.bfm.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {
    @Autowired
    EmployeeServiceInterface service;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp){
            Employee e = service.addEmployee(emp);
            return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> empList = service.getAllEmployee();
        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
    }

    @GetMapping("/getEmpById/{empId}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("empId") Long id){
        Employee e = service.getEmpById(id);
        return new ResponseEntity<Employee>(e,HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmp/{empId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("empId") Long id){
        try{
            service.deleteEmployeeById(id);
        }catch(BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getMsg());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{empId}/{name}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("empId") Long id, @PathVariable("name") String name){
        Employee e = service.updateEmployeeById(id,name);
        return new ResponseEntity<Employee>(e,HttpStatus.ACCEPTED);
    }

}
