package dev.joseafmoreira.collection.queue;

import dev.joseafmoreira.collection.AbstractLinkedListCollection;
import dev.joseafmoreira.node.LinearNode;
import pt.ipp.estg.ed.abstractdatatype.QueueADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Singly-linked list implementation of the {@code QueueADT} interface.
 * 
 * <h3>LinkedQueue</h3>
 * 
 * @param <T> the type of element stored in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractLinkedListCollection
 * @see QueueADT
 */
public class LinkedQueue<T> extends AbstractLinkedListCollection<T> implements QueueADT<T> {
    /**
     * The tail node of this queue
     */
    protected LinearNode<T> tail;

    /**
     * Constructs an empty LinkedQueue object.
     */
    public LinkedQueue() {
        super();
        tail = null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    public void enqueue(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");

        LinearNode<T> newNode = new LinearNode<>(element);
        if (tail == null)
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    public T dequeue() {
        T result = first();
        head = head.getNext();
        if (head == null)
            tail = null;
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    public T first() {
        if (isEmpty())
            throw new EmptyCollectionException("Queue is empty");

        return head.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        LinearNode<T> currentNode = head;
        while (currentNode != null) {
            result.append(currentNode.getElement()).append((currentNode.getNext() != null) ? ", " : "");
            currentNode = currentNode.getNext();
        }
        result.append("]");

        return result.toString();
    }
}
