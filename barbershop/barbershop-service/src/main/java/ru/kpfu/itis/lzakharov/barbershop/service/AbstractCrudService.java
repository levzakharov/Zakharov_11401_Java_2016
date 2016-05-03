package ru.kpfu.itis.lzakharov.barbershop.service;

import java.util.List;

/**
 * This abstract service provides CRUD operations.
 *
 * @param <T> Model type.
 */
public interface AbstractCrudService<T> {
    /**
     * This method provides saving entities in database.
     *
     * @param entity    Entity to save.
     * @return          Saved entity.
     */
    T save(T entity);

    /**
     * This method provides retrieving from database entity by using the id given as a method parameter.
     *
     * @param   id Entity's id
     * @return  Retrieved entity with
     */
    T findOne(Integer id);

    /**
     * This method provides retrieving all entities that are saved to the database.
     *
     * @return List of retrieved entities.
     */
    List<T> findAll();

    /**
     * This method provides deleting from database entity specified in method parameter.
     *
     * @param id Required entity's id.
     */
    void delete(Integer id);

    /**
     * This method provides updating an existing entity with information specified in method parameter.
     * @param entity    The new information of an existing entity.
     * @return          Updated entity.
     */
    T update(T entity);

}
