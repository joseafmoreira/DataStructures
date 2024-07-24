package dev.joseafmoreira.queue;

import dev.joseafmoreira.adts.QueueADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * ArrayQueue
 * </h2>
 * <p>
 * The {@code CircularArrayQueue} class that implements the {@link QueueADT QueueADT} interface.
 * </p>
 * <p>
 * The {@code CircularArrayQueue} is implemented using an array
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
    /**
     * This represents the default capacity of this queue
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * This represents the arrays containing the elements of this queue
     */
    protected T[] array;
    /**
     * This represents the head index in this queue
     */
    protected int head;
    /**
     * This represents the number of elements in this queue
     */
    protected int size;

    /**
     * Instantiate an empty ArrayQueue object
     */
    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Instantiate an empty ArrayQueue with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int initialCapacity) {
        array = (T[]) new Object[Math.max(initialCapacity, 0)];
        head = 0;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element can't be null");
        if (size() == array.length) expandCapacity();

        array[(head + size()) % array.length] = element;
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        T result = first();
        array[head] = null;
        head = (head + 1) % array.length;
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue is empty");

        return array[head];
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
        if (!isEmpty()) for (int i = 0; i < size(); i++) result.append(array[(head + i) % array.length]).append((((head + i) % array.length) == ((head + size() - 1) % array.length)) ? "" : ", ");
        result.append("]");

        return result.toString();
    }

    /**
     * Expands the capacity of the array used by this queue.
     * If the current array length is less than 2, the new array length will be increased by 1.
     * Otherwise, the new array length will be increased by half of the current array length.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        for (int i = 0; i < size(); i++) newArray[i] = array[(head + i) % array.length];

        array = newArray;
        head = 0;
    }
}
