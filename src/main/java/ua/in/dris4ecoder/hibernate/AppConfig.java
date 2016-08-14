package ua.in.dris4ecoder.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import ua.in.dris4ecoder.hibernate.controllers.DishController;
import ua.in.dris4ecoder.hibernate.controllers.EmployeeController;
import ua.in.dris4ecoder.hibernate.controllers.OrderController;
import ua.in.dris4ecoder.hibernate.model.dao.DishDao;
import ua.in.dris4ecoder.hibernate.model.dao.EmployeeDao;
import ua.in.dris4ecoder.hibernate.model.dao.OrderDao;
import ua.in.dris4ecoder.hibernate.model.dao.hibernate.HDishDao;
import ua.in.dris4ecoder.hibernate.model.dao.hibernate.HEmployeeDao;
import ua.in.dris4ecoder.hibernate.model.dao.hibernate.HOrderDao;

/**
 * Created by Alex Korneyko on 13.08.2016 20:47.
 */
@Configuration
public class AppConfig {

    @Bean
    Main mainObject(EmployeeController controller, DishController dishController, OrderController orderController) {
        Main main = new Main();
        main.setEmployeeController(controller);
        main.setDishController(dishController);
        main.setOrderController(orderController);
        return main;
    }

    @Bean
    EmployeeController employeeController(EmployeeDao employeeDao) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.setEmployeeDao(employeeDao);
        return employeeController;
    }

    @Bean
    DishController dishController(DishDao dishDao) {
        DishController dishController = new DishController();
        dishController.setDishDao(dishDao);
        return dishController;
    }

    @Bean
    OrderController orderController(EmployeeDao employeeDao, DishDao dishDao, OrderDao orderDao) {
        OrderController controller = new OrderController();
        controller.setDishDao(dishDao);
        controller.setEmployeeDao(employeeDao);
        controller.setOrderDao(orderDao);
        return controller;
    }

    @Bean
    EmployeeDao hEmployeeDao(SessionFactory sessionFactoryBean) {
        HEmployeeDao hEmployeeDao = new HEmployeeDao();
        hEmployeeDao.setSessionFactory(sessionFactoryBean);
        return hEmployeeDao;
    }

    @Bean
    DishDao hDishDao(SessionFactory sessionFactory) {
        HDishDao hDishDao = new HDishDao();
        hDishDao.setSessionFactory(sessionFactory);
        return hDishDao;
    }

    @Bean
    OrderDao orderDao(SessionFactory sessionFactory) {
        HOrderDao orderDao = new HOrderDao();
        orderDao.setSessionFactory(sessionFactory);
        return orderDao;
    }
}
