package dev.joseafmoreira.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.adts.ListADT;

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
     * This represents the number of modifications made in this list
     */
    private int modCount;

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
        modCount = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        return remove(first());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        return remove(last());
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
                for (int j = i; j < size() - 1; j++) array[j] = array[j + 1];
                size--;
                modCount++;

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
    public Iterator<T> iterator() {
        return new ArrayListIterator();
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

    /**
     * <h2>
     * ArrayListIterator
     * </h2>
     * <p>
     * The {@code ArrayListIterator} class that implements the {@link Iterator Iterator} interface.
     * </p>
     * <p>
     * Author: joseafmoreira
     * </p>
     */
    private class ArrayListIterator implements Iterator<T> {
        /**
         * This represents the index of the current element
         */
        private int currentIndex;
        /**
         * This represents the expected number of modifications made in this list
         */
        private int expectedModCount;
        /**
         * This represents if the iterator can remove an element from the list or not
         */
        private boolean okToRemove;

        /**
         * Instantiate a new ArrayListIterator object
         */
        private ArrayListIterator() {
            currentIndex = 0;
            expectedModCount = modCount;
            okToRemove = false;
        }

        /**
         * {@inheritDoc}
         * @throws ConcurrentModificationException if this list has been modified
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (expectedModCount != modCount) throw new ConcurrentModificationException("List has been modified");

            return currentIndex < size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException("Iteration out of elements");

            okToRemove = true;
            
            return array[currentIndex++];
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() throws IllegalStateException {
            if (!okToRemove) throw new IllegalStateException("Invalid remove operation call");

            ArrayList.this.remove(array[currentIndex - 1]);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
