package com.justpractice.demo.service;

import com.justpractice.demo.dto.EmployeeDto;
import com.justpractice.demo.entity.Employee;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
