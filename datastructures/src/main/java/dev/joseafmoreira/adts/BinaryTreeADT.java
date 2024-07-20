package dev.joseafmoreira.adts;

import java.util.Iterator;

/**
 * <h2>
 * BinaryTreeADT
 * </h2>
 * <p>
 * The {@code BinaryTreeADT} interface that specifies the behavior of a binary tree
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface BinaryTreeADT<T> {
    /**
     * Returns the root element of this binary tree.
     *
     * @return the root element of this binary tree
     */
    T getRoot();

    /**
     * Returns the element in this binary tree that matches the specified target.
     *
     * @param target the element to be found in this binary tree
     * @return the element in the binary tree that matches the specified target
     */
    T find(T target);

    /**
     * Returns an iterator over the elements in this binary tree using the pre-order traversal.
     *
     * @return an iterator over the elements in this binary tree using the pre-order traversal
     */
    Iterator<T> iteratorPreOrder();

    /**
     * Returns an iterator over the elements of this binary tree in in-order traversal order.
     *
     * @return an iterator over the elements of this binary tree in in-order traversal order
     */
    Iterator<T> iteratorInOrder();

    /**
     * Returns an iterator over the elements in this binary tree in post-order traversal.
     *
     * @return an iterator over the elements in this binary tree in post-order traversal
     */
    Iterator<T> iteratorPostOrder();

    /**
     * Returns an iterator that traverses the elements of the binary tree in level order.
     *
     * @return an iterator that traverses the elements of the binary tree in level order
     */
    Iterator<T> iteratorLevelOrder();

    /**
     * Checks if this binary tree contains a specific element.
     *
     * @param target the element to be checked for containment in this binary tree
     * @return true if this binary tree contains the specified element, false otherwise
     */
    boolean contains(T target);

    /**
     * Checks if this binary tree is empty.
     *
     * @return true if this binary tree is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this binary tree.
     *
     * @return the number of elements in this binary tree
     */
    int size();

    /**
     * Returns a string representation of this binary tree.
     *
     * @return a string representation of this binary tree
     */
    @Override
    String toString();
}
