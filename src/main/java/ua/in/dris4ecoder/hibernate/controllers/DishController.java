package ua.in.dris4ecoder.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.hibernate.model.Dish;
import ua.in.dris4ecoder.hibernate.model.DishCategory;
import ua.in.dris4ecoder.hibernate.model.dao.DishDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex Korneyko on 14.08.2016 17:22.
 */
public class DishController {

    private DishDao dishDao;

    @Transactional
    public void createDish() {

        Set<Dish> dishes;

        Dish dish = new Dish();
        dish.setName("Plov");
        dish.setCategory(DishCategory.MAIN);
        dish.setPrice(5.00F);
        dish.setWeight(300F);

        dishes = new HashSet<>(dishDao.findAll());
        if (!dishes.contains(dish)) {
            dishDao.save(dish);
        }

        dish = new Dish();
        dish.setName("Salad");
        dish.setCategory(DishCategory.SALAD);
        dish.setPrice(2.00F);
        dish.setWeight(100F);

        if (!dishes.contains(dish)) {
            dishDao.save(dish);
        }

        dish = new Dish();
        dish.setName("Potato");
        dish.setCategory(DishCategory.SIDE_DISH);
        dish.setPrice(3.00F);
        dish.setWeight(200F);

        if (!dishes.contains(dish)) {
            dishDao.save(dish);
        }
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

}
