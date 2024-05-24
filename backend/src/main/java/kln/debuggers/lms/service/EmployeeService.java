package kln.debuggers.lms.service;

import narxoz.kz.dto.EmployeeDto;
import narxoz.kz.entity.Employee;
import narxoz.kz.repository.EmployeeRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmplopyee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);





}
