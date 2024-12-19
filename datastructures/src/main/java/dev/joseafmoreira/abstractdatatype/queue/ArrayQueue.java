package dev.joseafmoreira.abstractdatatype.queue;

import dev.joseafmoreira.exception.EmptyCollectionException;
import pt.ipp.estg.ed.QueueADT;

/**
 * Resizable-array implementation of the {@code QueueADT} interface.
 * 
 * <h3>ArrayQueue</h3>
 * @param <T> the type of element stored in this queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see QueueADT
 */
public class ArrayQueue<T> implements QueueADT<T> {
    /**
     * The default capacity of this queue array
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * The array containing the elements of this queue
     */
    protected T[] array;
    /**
     * The number of elements in this queue
     */
    protected int size;

    /**
     * Constructs an empty ArrayQueue with a default capacity.
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty ArrayQueue with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        array = (T[]) new Object[(initialCapacity < 0) ? 0 : initialCapacity];
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
        array[size++] = element;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        T result = first();
        array[0] = null;
        for (int i = 1; i < size() - 1; i++)
            array[i - 1] = array[i];
        array[--size] = null;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue is empty");

        return array[0];
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
        for (int i = 0; i < size(); i++)
            result.append(array[i]).append((i == size() - 1) ? "]" : ", ");
        
        return result.toString();
    }

    /**
     * Expands the capacity of the array used to store the elements in this queue. <p>
     * If the current array length is 0 or 1, a new array with a capacity of the old length + 1 is created. <p>
     * Otherwise, a new array with a capacity increased by half of the current array's length is created. <p>
     * The elements from the current array are copied to the new array.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        for (int i = 0; i < size(); i++) newArray[i] = array[i];
        array = newArray;
    }
}
