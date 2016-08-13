package ua.in.dris4ecoder.hibernate.model.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.hibernate.model.Employee;
import ua.in.dris4ecoder.hibernate.model.dao.EmployeeDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 13.08.2016 20:34.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee load(Long id) {
        return null;
    }

    public List<Employee> findAll() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
