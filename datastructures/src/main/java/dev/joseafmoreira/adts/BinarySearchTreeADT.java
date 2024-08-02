package dev.joseafmoreira.adts;

import java.util.NoSuchElementException;

import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * BinarySearchTreeADT
 * </h2>
 * <p>
 * The {@code BinarySearchTreeADT} interface that specifies the behavior of a binary search tree
 * </p>
 * <p>
 * This abstract data type extends {@link BinaryTreeADT}
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    /**
     * Adds the specified element to this binary search tree.
     *
     * @param element the element to be added to this binary search tree
     * @throws NullPointerException if the element is null
     * @throws ClassCastException if the specified element isn't comparable
     */
    void addElement(T element) throws NullPointerException, ClassCastException;

    /**
     * Removes the specified element from this binary search tree if it is present.
     *
     * @param target the element to be removed from this binary search tree
     * @return the element that was removed from this binary search tree
     * @throws NullPointerException if the specified target is null
     * @throws EmptyCollectionException if this binary search tree is empty
     * @throws ClassCastException if the specified target isn't comparable
     * @throws NoSuchElementException if this binary search tree doesn't contain the specified target
     */
    T removeElement(T target) throws NullPointerException, EmptyCollectionException, ClassCastException, NoSuchElementException;

    /**
     * Removes all occurrences of the specified target element from this binary search tree.
     *
     * @param target the element to be removed from this binary search tree
     * @throws NullPointerException if the specified target is null
     * @throws EmptyCollectionException if this binary search tree is empty
     * @throws ClassCastException if the specified target isn't comparable
     * @throws NoSuchElementException if this binary search tree doesn't contain the specified target
     */
    void removeAllOccurrences(T target) throws NullPointerException, EmptyCollectionException, ClassCastException, NoSuchElementException;

    /**
     * Removes and returns the minimum element from this binary search tree.
     *
     * @return the minimum element in this binary search tree
     * @throws EmptyCollectionException if this binary search tree is empty
     */
    T removeMin() throws EmptyCollectionException;

    /**
     * Removes and returns the maximum element from this binary search tree.
     *
     * @return the maximum element in this binary search tree
     * @throws EmptyCollectionException if this binary search tree is empty
     */
    T removeMax() throws EmptyCollectionException;

    /**
     * Returns the minimum element in this binary search tree.
     *
     * @return the minimum element in this binary search tree
     * @throws EmptyCollectionException if this binary search tree is empty
     */
    T findMin() throws EmptyCollectionException;

    /**
     * Returns the maximum element in this binary search tree.
     *
     * @return the maximum element in this binary search tree
     * @throws EmptyCollectionException if this binary search tree is empty
     */
    T findMax() throws EmptyCollectionException;
}
