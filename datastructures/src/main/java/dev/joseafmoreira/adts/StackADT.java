package dev.joseafmoreira.adts;

import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * StackADT
 * </h2>
 * <p>
 * The <code>StackADT</code> interface that specifies the behavior of a stack
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface StackADT<T> {
    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element the element to be pushed onto this stack
     * @throws NullPointerException if the element is null
     */
    void push(T element) throws NullPointerException;

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return the element removed from the top of this stack
     * @throws EmptyCollectionException if this stack is empty
     */
    T pop() throws EmptyCollectionException;

    /**
     * Retrieves, but does not remove, the element at the top of this stack.
     *
     * @return the element at the top of this stack
     * @throws EmptyCollectionException if this stack is empty
     */
    T peek() throws EmptyCollectionException;

    /**
     * Checks if this stack is empty.
     *
     * @return true if this stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    int size();

    /**
     * Returns a string representation of this stack.
     *
     * @return a string representation of this stack
     */
    @Override 
    String toString();
}
