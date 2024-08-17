package com.justpractice.demo.service;

import com.justpractice.demo.dto.EmployeeDto;
import com.justpractice.demo.entity.Employee;
import com.justpractice.demo.mapper.EmployeeMapper;
import com.justpractice.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedeEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedeEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return null;
    }

}
