package dev.joseafmoreira.abstractdatatype.stack;

import dev.joseafmoreira.exception.EmptyCollectionException;
import pt.ipp.estg.ed.StackADT;

/**
 * Resizable-array implementation of the {@code StackADT} interface.
 * 
 * <h3>ArrayStack</h3>
 * @param <T> the type of element stored in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see StackADT
 */
public class ArrayStack<T> implements StackADT<T> {
    /**
     * The default capacity of this stack array
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * The array containing the elements of this stack
     */
    protected T[] array;
    /**
     * The number of elements in this stack
     */
    protected int size;

    /**
     * Constructs an empty ArrayStack with a default capacity.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty ArrayStack with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        array = (T[]) new Object[(initialCapacity < 0) ? 0 : initialCapacity];
        size = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element is null
     */
    @Override
    public void push(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element is null");

        if (size() == array.length) expandCapacity();
        array[size++] = element;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this stack is empty
     */
    @Override
    public T pop() throws EmptyCollectionException {
        T result = peek();
        array[--size] = null;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this stack is empty
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Stack is empty");

        return array[size() - 1];
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
     * Expands the capacity of the array used to store the elements in this stack. <p>
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
