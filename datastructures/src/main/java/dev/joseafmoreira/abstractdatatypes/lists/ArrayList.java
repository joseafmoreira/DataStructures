package dev.joseafmoreira.abstractdatatypes.lists;

import java.util.Iterator;

import dev.joseafmoreira.exceptions.EmptyCollectionException;
import pt.ipp.estg.ed.ListADT;

/**
 * Resizable-array implementation of the {@code ListADT} interface
 * 
 * <h3>ArrayList</h3>
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public class ArrayList<T> implements ListADT<T> {
    /**
     * The default capacity of this list array
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * The array containing the elements of this list
     */
    protected T[] array;
    /**
     * The number of elements in this list
     */
    protected int size;
    /**
     * The number of modifications made to this list
     */
    protected int modCount;

    /**
     * Constructs an empty ArrayStack with a default capacity.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty ArrayStack with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        array = (T[]) new Object[(initialCapacity < 0) ? 0 : initialCapacity];
        size = 0;
        modCount = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the target is null
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T remove(T target) throws NullPointerException, EmptyCollectionException {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T last() throws EmptyCollectionException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
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
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Expands the capacity of the array used to store the elements in the list.
     * If the current array length is 0 or 1, a new array with a capacity of the old length + 1 is created.
     * Otherwise, a new array with a capacity increased by half of the current array's length is created.
     * The elements from the current array are copied to the new array.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[(array.length < 2) ? array.length + 1 : array.length + (array.length / 2)];
        for (int i = 0; i < size(); i++) newArray[i] = array[i];
        array = newArray;
    }
}
