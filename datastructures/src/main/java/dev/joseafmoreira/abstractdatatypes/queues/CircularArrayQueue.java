package dev.joseafmoreira.abstractdatatypes.queues;

import dev.joseafmoreira.exceptions.EmptyCollectionException;
import pt.ipp.estg.ed.QueueADT;

/**
 * Circular resizable-array implementation of the {@code QueueADT} interface.
 * 
 * <h3>CircularArrayQueue</h3>
 * @param <T> the type of element stored in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see QueueADT
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
    /**
     * The default capacity of this queue array
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * The array containing the elements of this queue
     */
    protected T[] array;
    /**
     * The index of the front element in this queue
     */
    protected int frontIndex;
    /**
     * The index of the rear element in this queue
     */
    protected int rearIndex;
    /**
     * The number of elements in this queue
     */
    protected int size;

    /**
     * Constructs an empty CircularArrayQueue with a default capacity.
     */
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty CircularArrayQueue with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int initialCapacity) {
        array = (T[]) new Object[(initialCapacity < 0) ? 0 : initialCapacity];
        frontIndex = 0;
        rearIndex = 0;
        size = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element is null
     */
    @Override
    public void enqueue(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element is null");

        if (size() == array.length) expandCapacity();
        array[rearIndex] = element;
        rearIndex = (rearIndex + 1) % array.length;
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue is empty");

        T element = array[frontIndex];
        array[frontIndex] = null;
        frontIndex = (isEmpty()) ? 0 : (frontIndex + 1) % array.length;
        rearIndex = (isEmpty()) ? 0 : rearIndex;
        size--;

        return element;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue is empty");

        return array[frontIndex];
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
        for (int i = frontIndex; i != rearIndex; i = (i + 1) % array.length) result.append(array[i]).append((i < size() - 1) ? ", " : "");
        result.append("]");

        return result.toString();
    }

    /**
     * Expands the capacity of the array used to store the elements in this queue.
     * If the current array length is 0 or 1, a new array with a capacity of the old length + 1 is created.
     * Otherwise, a new array with a capacity increased by half of the current array's length is created.
     * The elements from the current array are copied to the new array.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        int j = 0;
        for (int i = frontIndex; i != rearIndex; i = (i + 1) % array.length) newArray[j++] = array[i];
        frontIndex = 0;
        rearIndex = --j;
        array = newArray;
    }
}
