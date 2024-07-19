package dev.joseafmoreira.adts;

/**
 * <h2>
 * BinarySearchTreeADT
 * </h2>
 * <p>
 * The <code>BinarySearchTreeADT</code> interface that specifies the behavior of a binary search tree
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
     */
    void addElement(T element);

    /**
     * Removes the specified element from this binary search tree if it is present.
     *
     * @param target the element to be removed from this binary search tree
     * @return the element that was removed from this binary search tree
     */
    T removeElement(T target);

    /**
     * Removes all occurrences of the specified target element from this binary search tree.
     *
     * @param target the element to be removed from this binary search tree
     */
    void removeAllOccurrences(T target);

    /**
     * Removes and returns the minimum element from this binary search tree.
     *
     * @return the minimum element in this binary search tree
     */
    T removeMin();

    /**
     * Removes and returns the maximum element from this binary search tree.
     *
     * @return the maximum element in this binary search tree
     */
    T removeMax();

    /**
     * Returns the minimum element in this binary search tree.
     *
     * @return the minimum element in this binary search tree
     */
    T findMin();

    /**
     * Returns the maximum element in this binary search tree.
     *
     * @return the maximum element in this binary search tree
     */
    T findMax();
}
