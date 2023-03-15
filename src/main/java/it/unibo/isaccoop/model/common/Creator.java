package it.unibo.isaccoop.model.common;

import java.util.List;

/**
 * Functional interface that manages the creation of items and enemies.
<<<<<<< HEAD
 * @param <E>
 * */
public interface Creator<E> {
    /**
     * @return List<E> list of objects
=======
 *
 * @param <E> type of {@link Creator}
 * */
public interface Creator<E> {
    /**
     * Method to create a {@link List} of <E> type objects.
     *
     * @return {@link List} of <E> type with created objects
>>>>>>> b2e444e8e7d3b019434ac8f7684b55f3f59037e9
     * */
    List<E> create();
}
