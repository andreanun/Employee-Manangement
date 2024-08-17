package com.justpractice.demo.service;

import com.justpractice.demo.dto.EmployeeDto;
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);



}
