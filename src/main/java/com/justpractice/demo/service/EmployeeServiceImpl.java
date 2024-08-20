package com.justpractice.demo.service;

import com.justpractice.demo.dto.EmployeeDto;
import com.justpractice.demo.entity.Employee;
import com.justpractice.demo.exception.EmployeeNotFoundException;
import com.justpractice.demo.mapper.EmployeeMapper;
import com.justpractice.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
//    TODO: Refactor to Optionals and constructor injection

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedeEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedeEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id: " + employeeId + "does not exist."));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)   //lambda -> method references
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

       Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee by id: " + employeeId + "does not exist.")
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(long employeeId) {

        Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee by id: " + employeeId + "does not exist.")
        );

        employeeRepository.deleteById(employeeId);
    }

}
