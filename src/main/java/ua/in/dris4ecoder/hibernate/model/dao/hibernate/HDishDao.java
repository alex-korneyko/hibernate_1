package ua.in.dris4ecoder.hibernate.model.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.hibernate.model.Dish;
import ua.in.dris4ecoder.hibernate.model.dao.DishDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:17.
 */
public class HDishDao implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
