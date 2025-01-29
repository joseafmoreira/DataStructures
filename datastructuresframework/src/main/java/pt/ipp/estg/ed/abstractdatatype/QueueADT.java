package pt.ipp.estg.ed.abstractdatatype;

import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * A queue is a linear abstract data type that follows the First In, First Out
 * (FIFO) principle
 * meaning that the first element added to this queue will be the first one to
 * be removed from it.
 * <p>
 * 
 * The common operations for a queue include:
 * <p>
 * <ul>
 * <li>{@link #enqueue(Object)}: Adds an element to the rear of this queue</li>
 * <li>{@link #dequeue()}: Removes an element from the front of this queue</li>
 * <li>{@link #first()}: Returns the element from the front of this queue</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>QueueADT</h3>
 * 
 * @param <T> the type of elements in this queue
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 * @see CollectionADT
 */
public interface QueueADT<T> extends CollectionADT<T> {
    /**
     * Adds an element to the rear of this queue.
     * 
     * @param element the element to be added
     * @throws NullPointerException if the specified element is null and
     *                              this queue does not permit null elements
     */
    void enqueue(T element);

    /**
     * Removes an element from the front of this queue.
     * 
     * @return the element from the front of this queue
     * @throws EmptyCollectionException if this queue is empty
     */
    T dequeue();

    /**
     * Returns the element from the front of this queue
     * 
     * @return the element from the front of this queue
     * @throws EmptyCollectionException if this queue is empty
     */
    T first();
}
