package ua.in.dris4ecoder.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.hibernate.model.Employee;
import ua.in.dris4ecoder.hibernate.model.Position;
import ua.in.dris4ecoder.hibernate.model.dao.EmployeeDao;

/**
 * Created by Alex Korneyko on 13.08.2016 20:37.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000F);

        employeeDao.save(employee);

    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
