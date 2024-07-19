package dev.joseafmoreira.adts;

/**
 * <h2>
 * UnorderedListADT
 * </h2>
 * <p>
 * The <code>UnorderedListADT</code> interface that specifies the behavior of an unordered list
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
     */
    void addToFront(T element);

    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the rear of this list
     */
    void addToRear(T element);

    /**
     * Adds the specified element after the target element in this list.
     *
     * @param element the element to be added
     * @param target the element after which the new element will be added
     */
    void addAfter(T element, T target);
}
