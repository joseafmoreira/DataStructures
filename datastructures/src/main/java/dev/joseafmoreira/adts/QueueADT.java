package dev.joseafmoreira.adts;

import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * QueueADT
 * </h2>
 * <p>
 * The {@code QueueADT} interface that specifies the behavior of a queue
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface QueueADT<T> {
    /**
     * Adds the specified element to the end of this queue.
     *
     * @param element the element to be added to this queue
     * @throws NullPointerException if the element is null
     */
    void enqueue(T element) throws NullPointerException;

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element removed from the front of this queue
     * @throws EmptyCollectionException if this queue is empty
     */
    T dequeue() throws EmptyCollectionException;

    /**
     * Returns the element at the front of this queue without removing it.
     *
     * @return the element at the front of this queue
     * @throws EmptyCollectionException if this queue is empty
     */
    T first() throws EmptyCollectionException;

    /**
     * Checks if this queue is empty.
     *
     * @return true if this queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int size();

    /**
     * Returns a string representation of the elements in this queue.
     *
     * @return a string representation of the elements in this queue
     */
    @Override
    String toString();
}
