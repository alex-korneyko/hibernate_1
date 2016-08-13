package ua.in.dris4ecoder.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.in.dris4ecoder.hibernate.controllers.EmployeeController;

/**
 * Created by Alex Korneyko on 13.08.2016 15:32.
 */
public class Main {

    private EmployeeController employeeController;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {

        employeeController.createEmployee();

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
