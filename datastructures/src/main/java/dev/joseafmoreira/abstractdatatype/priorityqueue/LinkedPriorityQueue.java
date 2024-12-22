package dev.joseafmoreira.abstractdatatype.priorityqueue;

import dev.joseafmoreira.abstractdatatype.binarytree.heap.LinkedHeap;
import dev.joseafmoreira.exception.EmptyCollectionException;
import dev.joseafmoreira.node.PriorityQueueNode;

/**
 * LinkedHeap implementation of the priority queue abstract data type.
 * 
 * <h3>LinkedPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedHeap
 * @see PriorityQueueNode
 */
public class LinkedPriorityQueue<T> extends LinkedHeap<PriorityQueueNode<T>> {
    /**
     * Construct an empty LinkedPriorityQueue object.
     */
    public LinkedPriorityQueue() {
        super();
    }

    /**
     * Adds an element to this priority queue at the proper location.
     *
     * @param element  the element to be added
     * @param priority the priority of the element
     */
    public void addElement(T element, int priority) {
        addElement(new PriorityQueueNode<>(element, priority));
    }

    /**
     * Removes the element from the root of this priority queue.
     * 
     * @return the element from the root of this priority queue
     */
    public T removeNext() throws EmptyCollectionException {
        return removeMin().getElement();
    }
}
