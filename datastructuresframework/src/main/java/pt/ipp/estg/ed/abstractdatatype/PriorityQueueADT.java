package pt.ipp.estg.ed.abstractdatatype;

import pt.ipp.estg.ed.exception.EmptyCollectionException;

public interface PriorityQueueADT<T> extends IterableCollectionADT<T> {
    /**
     * Adds an element to this priority queue at the proper location.
     * 
     * @param element  the specified element
     * @param priority the specified priority
     * @throws NullPointerException if the specified element is null and
     *                              this priority queue does not allow null elements
     */
    void add(T element, int priority);

    /**
     * Returns the element from the root of this priority queue.
     * 
     * @return the element from the root of this priority queue
     * @throws EmptyCollectionException if this priority queue is empty
     */
    T peek();

    /**
     * Removes the element from the root of this priority queue.
     * 
     * @return the element from the root of this priority queue
     * @throws EmptyCollectionException if this priority queue is empty
     */
    T remove();
}
