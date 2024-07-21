package dev.joseafmoreira.adts;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * ListADT
 * </h2>
 * <p>
 * The {@code ListADT} interface that specifies the behavior of a list
 * </p>
 * <p>
 * This abstract data type extends {@link Iterable}
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface ListADT<T> extends Iterable<T> {
    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element in this list
     * @throws EmptyCollectionException if this list is empty
     */
    T removeFirst() throws EmptyCollectionException;

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws EmptyCollectionException if this list is empty
     */
    T removeLast() throws EmptyCollectionException;

    /**
     * Removes the specified element from this list, if it is present.
     *
     * @param element the element to be removed from this list
     * @return the removed element
     * @throws NullPointerException if the element is null
     * @throws EmptyCollectionException if this list is empty
     * @throws NoSuchElementException if this list doesn't contain the specified element
     */
    T remove(T element) throws NullPointerException, EmptyCollectionException, NoSuchElementException;

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws EmptyCollectionException if this list is empty
     */
    T first() throws EmptyCollectionException;

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws EmptyCollectionException if this list is empty
     */
    T last() throws EmptyCollectionException;

    /**
     * Checks if this list contains a specific element.
     *
     * @param target the element to be checked for presence in this list
     * @return true if this list contains the specified element, false otherwise
     */
    boolean contains(T target);

    /**
     * Checks if this list is empty.
     *
     * @return true if this list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    String toString();
}
