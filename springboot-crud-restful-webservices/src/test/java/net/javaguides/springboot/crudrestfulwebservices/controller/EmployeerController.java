package net.javaguides.springboot.crudrestfulwebservices.controller;


import net.javaguides.springboot.crudrestfulwebservices.exception.ResourceNotFoundException;
import net.javaguides.springboot.crudrestfulwebservices.model.Employee;
import net.javaguides.springboot.crudrestfulwebservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeerController {
    @Autowired
    private EmployeeRepository  employeeRepository;
    //create get all employees api
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //create employee
    @PostMapping("/employees")
    public Employee createEmployee(@Validated @RequestBody Employee employee){
      return employeeRepository.save(employee);
    }
    //get employee by id
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId){

       Employee employee = employeeRepository.findAllById(Collections.singleton(employeeId)).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id ::"+employeeId));
       return ResponseEntity.ok().body(employee);
    }
    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId ,@RequestBody Employee employeeDetails
     )throws ResourceNotFoundException{

        Employee employee = employeeRepository.findAllById(Collections.singleton(employeeId)).orElseThrow(()-> new
                ResourceNotFoundException("Employee not found for this id ::"+employeeId));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName);
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);
    }
    //delete employee by id
    @DeleteMapping("/emloyees/{id}")
    public ResponseEntity <?>deleteEmployee(@PathVariable(value = "id") long employeeId)
            throws ResourceNotFoundException{
        employeeRepository.findAllById(Collections.singleton(employeeId)).orElseThrow(()-> new
                ResourceNotFoundException("Employee not found for this id ::"+employeeId));

        employeeRepository.deleteAllById(employeeId);
        return ResponseEntity.ok().build();

    }

}
