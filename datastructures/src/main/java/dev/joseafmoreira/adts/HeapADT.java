package dev.joseafmoreira.adts;

/**
 * <h2>
 * HeapADT
 * </h2>
 * <p>
 * The <code>HeapADT</code> interface that specifies the behavior of a heap
 * </p>
 * <p>
 * This abstract data type extends {@link BinaryTreeADT}
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {
    /**
     * Adds the specified element to this heap.
     *
     * @param element the element to be added to this heap
     */
    void addElement(T element);

    /**
     * Removes and returns the minimum element from this heap.
     *
     * @return the minimum element from this heap
     */
    T removeMin();

    /**
     * Returns the minimum element in this heap.
     *
     * @return the minimum element in this heap
     */
    T findMin();
}
