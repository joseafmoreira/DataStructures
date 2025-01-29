package dev.joseafmoreira.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import dev.joseafmoreira.collection.AbstractIterableCollection;
import pt.ipp.estg.ed.abstractdatatype.ListADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code ListADT} interface.
 * 
 * <h3>ArrayList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class ArrayList<T> extends AbstractIterableCollection<T> implements ListADT<T> {
    /**
     * The default capacity of this list array
     */
    protected static final int DEFAULT_CAPACITY = 10;
    /**
     * The array containing the elements of this list
     */
    protected T[] array;
    /**
     * The number of modifications made to this list
     */
    protected int modCount;

    /**
     * Constructs an empty ArrayList with a default capacity.
     */
    protected ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty ArrayList with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    protected ArrayList(int initialCapacity) {
        super();
        array = (T[]) new Object[(initialCapacity < 0) ? 0 : initialCapacity];
        modCount = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T get(int index) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        return array[index];
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    public void set(int index, T element) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (element == null)
            throw new NullPointerException("Element is null");
        array[index] = element;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T remove(int index) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        T result = array[index];
        array[index] = null;
        for (int i = index; i < size() + 1; i++)
            array[i] = array[i + 1];
        array[--size] = null;
        modCount++;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Expands the capacity of the array used to store the elements in this list.
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
        for (int i = 0; i < size(); i++)
            newArray[i] = array[i];
        array = newArray;
    }

    /**
     * {@code Iterator} implementation for the {@code ArrayList} class
     */
    private class ArrayListIterator implements Iterator<T> {
        /**
         * The current index of this list array
         */
        private int currentIndex;
        /**
         * The expected number of modifications made to this list
         */
        private int expectedModCount;
        /**
         * The flag indicating if it's ok to call the remove method
         */
        private boolean okToRemove;

        /**
         * Constructs an empty ArrayListIterator object.
         */
        public ArrayListIterator() {
            currentIndex = 0;
            expectedModCount = modCount;
            okToRemove = false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public T next() throws ConcurrentModificationException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");

            okToRemove = true;
            return array[currentIndex++];
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public void remove() throws ConcurrentModificationException, IllegalStateException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");
            if (!okToRemove)
                throw new IllegalStateException("Invalid remove call");

            ArrayList.this.remove(array[--currentIndex]);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
