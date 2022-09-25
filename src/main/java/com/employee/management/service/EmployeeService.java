package com.employee.management.service;

import com.employee.management.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> employeeList = Arrays.asList(new Employee(1, "first emp", "Washington"),
            new Employee(2, "second emp", "Canada")
    );

    public List<Employee> getAllEmployees() {
        return employeeList;

    }

    public Employee getEmployee(int empId) {
        return employeeList.stream().
                filter(employee -> (employee.getEmployeeId() == empId)).findFirst().get();

    }

    public void createEmployee(Employee employee) {
        employeeList.add(employee);
    }


    public void updateEmployee(Employee employee) {
        List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == employee.getEmployeeId()) {
                emp.setEmployeeCity(employee.getEmployeeCity());
                emp.setEmployeeName((employee.getEmployeeName()));
            }
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;
    }

    public void deleteEmployee(int empId) {
        List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == empId) continue;
            tempEmployee.add(emp);

        }
        this.employeeList = tempEmployee;

    }
}
