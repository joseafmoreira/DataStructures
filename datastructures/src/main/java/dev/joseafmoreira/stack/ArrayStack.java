package dev.joseafmoreira.stack;

import dev.joseafmoreira.adts.StackADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * ArrayStack
 * </h2>
 * <p>
 * The {@code ArrayStack} class that implements the {@link StackADT StackADT} interface.
 * </p>
 * <p>
 * The {@code ArrayStack} is implemented using an array
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class ArrayStack<T> implements StackADT<T> {
    /**
     * This represents the default capacity of this stack
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * This represents the arrays containing the elements of this stack
     */
    protected T[] array;
    /**
     * This represents the number of elements in this stack
     */
    protected int size;

    /**
     * Instantiate an empty ArrayStack object
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Instantiate an empty ArrayStack with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        array = (T[]) new Object[Math.max(initialCapacity, 0)];
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element is null");
        if (size() == array.length) expandCapacity();

        array[size++] = element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() throws EmptyCollectionException {
        T result = peek();
        array[--size] = null;

        return result;
    }

    /**
     * {@inheritDoc}
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
        if (!isEmpty()) for (int i = 0; i < size(); i++) result.append(array[i]).append((i == size() - 1) ? "" : ", ");
        result.append("]");

        return result.toString();
    }

    /**
     * Expands the capacity of the array used by the stack.
     * If the current array length is less than 2, the new array length will be increased by 1.
     * Otherwise, the new array length will be increased by half of the current array length.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        for (int i = 0; i < size(); i++) newArray[i] = array[i];

        array = newArray;
    }
}
