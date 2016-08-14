package ua.in.dris4ecoder.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.in.dris4ecoder.hibernate.controllers.DishController;
import ua.in.dris4ecoder.hibernate.controllers.EmployeeController;
import ua.in.dris4ecoder.hibernate.controllers.OrderController;

import java.util.Arrays;

/**
 * Created by Alex Korneyko on 13.08.2016 15:32.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {

        employeeController.createEmployee();
        dishController.createDish();
        orderController.createOrder("John", Arrays.asList("Plov", "Salad"), 1);
        orderController.createOrder("John", Arrays.asList("Potato", "Salad"), 2);
        orderController.createOrder("John", Arrays.asList("Plov", "Potato"), 3);

        orderController.printAllOrders();

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
