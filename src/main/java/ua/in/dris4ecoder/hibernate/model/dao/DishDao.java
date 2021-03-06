package ua.in.dris4ecoder.hibernate.model.dao;

import ua.in.dris4ecoder.hibernate.model.Dish;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:16.
 */
public interface DishDao {

    void save(Dish dish);

    List<Dish> findAll();

    Dish findByName(String name);

}
