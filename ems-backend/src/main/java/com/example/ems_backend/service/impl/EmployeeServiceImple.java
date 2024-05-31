package com.example.ems_backend.service.impl;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.ResourceNotFoundException;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImple implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto createEmployee(EmployeeDto employeeDto) {
    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
    Employee savedEmployee = employeeRepository.save(employee);

    return EmployeeMapper.mapToEmployeeDto(savedEmployee);
  }

  @Override
  public EmployeeDto getEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).
            orElseThrow(()->
             new ResourceNotFoundException("Employee is not exist with given id "+id));
    return EmployeeMapper.mapToEmployeeDto(employee);
  }

  @Override
  public List<EmployeeDto> getAllEmployees() {
    List<Employee> employees  = employeeRepository.findAll();

    return employees.stream().map(employee ->
            EmployeeMapper.mapToEmployeeDto(employee)
            ).collect(Collectors.toList());
  }

  @Override
  public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
    Employee employee = employeeRepository.findById(employeeId).
            orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id "+employeeId));
   employee.setFirstName(updatedEmployee.getFirstName());
   employee.setLastName(updatedEmployee.getLastName());
   employee.setEmail(updatedEmployee.getEmail());
   employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(employee);
  }

  @Override
  public void deleteEmployee(Long id) {
    Employee employee = employeeRepository.findById(id).
            orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id "+id));
   employeeRepository.deleteById(id);
  }
}



