package ua.in.dris4ecoder.hibernate.model.dao.hibernate;

import org.hibernate.Session;
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

    public void save(Employee employee) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    public Employee load(Long id) {
        return null;
    }

    public List<Employee> findAll() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list(); //select * from employee
    }

    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
