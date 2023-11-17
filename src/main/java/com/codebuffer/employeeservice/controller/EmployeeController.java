package com.codebuffer.employeeservice.controller;

import com.codebuffer.employeeservice.model.Employee;
import com.codebuffer.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}" + employee);
        return repository.addEmployee(employee);
    }

    @GetMapping("/{Id}")
    public Employee findById(@PathVariable Long Id) {
        LOGGER.info("Employee find by id={}" + Id);
        return repository.findById(Id);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee find all");
        return repository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}" + departmentId);
        return repository.findByDepartmentId(departmentId);
    }
}
