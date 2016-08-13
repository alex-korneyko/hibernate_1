package ua.in.dris4ecoder.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import ua.in.dris4ecoder.hibernate.controllers.EmployeeController;
import ua.in.dris4ecoder.hibernate.model.dao.EmployeeDao;
import ua.in.dris4ecoder.hibernate.model.dao.hibernate.HEmployeeDao;

/**
 * Created by Alex Korneyko on 13.08.2016 20:47.
 */
@Configuration
public class AppConfig {

    @Bean
    Main mainObject(EmployeeController controller) {
        Main main = new Main();
        main.setEmployeeController(controller);
        return main;
    }

    @Bean
    EmployeeController employeeController(EmployeeDao employeeDao) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.setEmployeeDao(employeeDao);
        return employeeController;
    }


    @Bean
    HEmployeeDao hEmployeeDao(SessionFactory sessionFactoryBean) {
        HEmployeeDao hEmployeeDao = new HEmployeeDao();
        hEmployeeDao.setSessionFactory(sessionFactoryBean);
        return hEmployeeDao;
    }
}
