package dev.joseafmoreira.list;

import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * ArrayList
 * </h2>
 * <p>
 * The {@code ArrayList} abstract class that implements the {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code ArrayList} is implemented using an array
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public abstract class ArrayList<T> implements ListADT<T> {
    /**
     * This represents the default capacity of this list
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * This represents the arrays containing the elements of this list
     */
    protected T[] array;
    /**
     * This represents the number of elements in this list
     */
    protected int size;

    /**
     * Instantiate an empty ArrayList object
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Instantiate an empty ArrayList with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        array = (T[]) new Object[Math.max(initialCapacity, 0)];
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        T result = first();
        array[0] = null;
        for (int i = 0; i < size() - 1; i++) array[i] = array[i + 1];
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        T result = last();
        array[--size] = null;

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(T target) throws NullPointerException, EmptyCollectionException, NoSuchElementException {
        if (target == null) throw new NullPointerException("Target is null");
        if (isEmpty()) throw new EmptyCollectionException("List is empty");

        for (int i = 0; i < size(); i++) {
            if (array[i].equals(target)) {
                array[i] = null;
                for (int j = i; j < size() - 1; j++) {
                    array[j] = array[j + 1];
                }

                return target;
            }
        }

        throw new NoSuchElementException("Target not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List is empty");

        return array[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List is empty");

        return array[size() - 1];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
        for (int i = 0; i < size(); i++) if (array[i].equals(target)) return true;

        return false;
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
     * Expands the capacity of the array used by the list.
     * If the current array length is less than 2, the new array length will be increased by 1.
     * Otherwise, the new array length will be increased by half of the current array length.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        for (int i = 0; i < size(); i++) newArray[i] = array[i];

        array = newArray;
    }
}
