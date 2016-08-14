package ua.in.dris4ecoder.hibernate.model.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.in.dris4ecoder.hibernate.model.Order;
import ua.in.dris4ecoder.hibernate.model.dao.OrderDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:18.
 */
@SuppressWarnings("JpaQlInspection")
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from ua.in.dris4ecoder.hibernate.model.Order o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
