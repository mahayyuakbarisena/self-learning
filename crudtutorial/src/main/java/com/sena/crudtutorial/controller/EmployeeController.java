package com.sena.crudtutorial.controller;

import com.sena.crudtutorial.exception.ResourceNotFoundException;
import com.sena.crudtutorial.model.Employee;
import com.sena.crudtutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //get employees
    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return this.employeeRepository.findAll();
    }

    //get employees by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    //save employee
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepository.save(employee);
    }

    //update employee
    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:: " + employeeId));
        employee.setEmail(employeeDetails.getEmail());
        employee.setFirst_name(employeeDetails.getFirst_name());
        employee.setLast_name(employeeDetails.getLast_name());

        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

    //delete employee
    @DeleteMapping("employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:: " + employeeId));
        this.employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }


}
