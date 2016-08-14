package ua.in.dris4ecoder.hibernate.model.dao;

import ua.in.dris4ecoder.hibernate.model.Employee;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.08.2016 20:31.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    void remove(Employee employee);
}
