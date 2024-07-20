package dev.joseafmoreira.queue;

import dev.joseafmoreira.adts.QueueADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.node.Node;

/**
 * <h2>
 * LinkedQueue
 * </h2>
 * <p>
 * The {@code LinkedQueue} class that implements the {@link QueueADT QueueADT} interface.
 * </p>
 * <p>
 * The {@code LinkedQueue} is implemented using linked {@link Node nodes}
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /**
     * This represents the head node of this queue
     */
    protected Node<T> head;
    /**
     * This represents the tail node of this queue
     */
    protected Node<T> tail;
    /**
     * This represents the number of elements in this queue
     */
    protected int size;

    /**
     * Instantiate an empty LinkedQueue object
     */
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element is null");

        Node<T> newNode = new Node<>(element);
        if (isEmpty()) head = newNode;
        else tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        T result = first();
        head = head.getNext();
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue is empty");

        return head.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (!isEmpty()) {
            Node<T> currentNode = head;
            while (currentNode != null) {
                result.append(currentNode.getElement());
                if (currentNode.getNext() != null) result.append(", ");
                currentNode = currentNode.getNext();
            }
        }
        result.append("]");

        return result.toString();
    }
}
