package kln.debuggers.lms.mapper;

import kln.debuggers.lms.dto.EmployeeDto;
import kln.debuggers.lms.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
              employee.getId(),
              employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPassword()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPassword()
        );
    }

}
