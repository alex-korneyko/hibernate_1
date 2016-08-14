package ua.in.dris4ecoder.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.in.dris4ecoder.hibernate.controllers.DishController;
import ua.in.dris4ecoder.hibernate.controllers.EmployeeController;

/**
 * Created by Alex Korneyko on 13.08.2016 15:32.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {

        employeeController.createEmployee();
        dishController.createDish();

        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
