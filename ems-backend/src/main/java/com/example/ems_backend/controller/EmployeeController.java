package com.example.ems_backend.controller;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;
 // Build Add employee rest api
 @PostMapping
  public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

    EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
   EmployeeDto employeeDto = employeeService.getEmployeeById(id);
   return  ResponseEntity.ok(employeeDto);
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
   List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
   return ResponseEntity.ok(employeeDtos);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id
          ,@RequestBody EmployeeDto employeeDto){
   EmployeeDto employeeDto1 = employeeService.updateEmployee(id,employeeDto);
   return ResponseEntity.ok(employeeDto1);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
   employeeService.deleteEmployee(id);
   return ResponseEntity.ok("Employee deleted successfully");
  }

}
