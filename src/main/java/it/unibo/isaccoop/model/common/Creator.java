package it.unibo.isaccoop.model.common;

import java.util.List;

/**
 * Functional interface that manages the creation of items and enemies.
 * @param <E>
 * */
public interface Creator<E> {
    /**
     * @return List<E> list of objects
     * */
    List<E> create();
}
