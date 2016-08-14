package ua.in.dris4ecoder.hibernate.model.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.in.dris4ecoder.hibernate.model.Order;
import ua.in.dris4ecoder.hibernate.model.dao.OrderDao;

/**
 * Created by Alex Korneyko on 14.08.2016 17:18.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
