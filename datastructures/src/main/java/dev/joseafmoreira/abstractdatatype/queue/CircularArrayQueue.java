package dev.joseafmoreira.abstractdatatype.queue;

import dev.joseafmoreira.exception.EmptyCollectionException;
import pt.ipp.estg.ed.QueueADT;

/**
 * Circular resizable-array implementation of the {@code QueueADT} interface.
 * 
 * <h3>ArrayQueue</h3>
 * 
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
     * The number of elements in this queue
     */
    protected int size;
    /**
     * The index of the first element in this queue
     */
    protected int first;
    /**
     * The index of the last index of this queue
     */
    protected int last;

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
        size = 0;
        first = 0;
        last = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element is null
     */
    @Override
    public void enqueue(T element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Element is null");

        if (size() == array.length)
            expandCapacity();
        array[last] = element;
        last = (last + 1) % array.length;
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        T result = first();
        array[first] = null;
        first = (isEmpty() ? 0 : (first + 1) % array.length);
        last = (isEmpty() ? 0 : last);
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Queue is empty");

        return array[first];
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
        int count = 0;
        for (int i = first; count < size(); i = (i + 1) % array.length) {
            result.append(array[i]).append((count < (size() - 1)) ? ", " : "");
            count++;
        }
        result.append("]");

        return result.toString();
    }

    /**
     * Expands the capacity of the array used to store the elements in this queue.
     * <p>
     * If the current array length is 0 or 1, a new array with a capacity of the old
     * length + 1 is created.
     * <p>
     * Otherwise, a new array with a capacity increased by half of the current
     * array's length is created.
     * <p>
     * The elements from the current array are copied to the new array.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        int count = 0;
        for (int i = first; count < size(); i = (i + 1) % array.length)
            newArray[count++] = array[i];
        first = 0;
        last = size();
        array = newArray;
    }
}
