package dev.joseafmoreira.adts;

import java.util.NoSuchElementException;

/**
 * <h2>
 * UnorderedListADT
 * </h2>
 * <p>
 * The {@code UnorderedListADT} interface that specifies the behavior of an unordered list
 * </p>
 * <p>
 * This abstract data type extends {@link ListADT}
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface UnorderedListADT<T> extends ListADT<T> {
    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the front of this list
     * @throws NullPointerException if the specified element is null
     */
    void addToFront(T element) throws NullPointerException;

    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the rear of this list
     * @throws NullPointerException if the specified element is null
     */
    void addToRear(T element) throws NullPointerException;

    /**
     * Adds the specified element after the target element in this list.
     *
     * @param element the element to be added
     * @param target the element after which the new element will be added
     * @throws NullPointerException if the specified element and/or target are null
     * @throws NoSuchElementException if the specified target isn't in this list
     */
    void addAfter(T element, T target) throws NullPointerException, NoSuchElementException;
}
