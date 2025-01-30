package dev.joseafmoreira.collection.list.ordered;

import dev.joseafmoreira.algorithm.search.BinarySearch;
import dev.joseafmoreira.collection.list.ArrayList;
import pt.ipp.estg.ed.abstractdatatype.OrderedListADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code OrderedListADT} interface
 * using the {@code ArrayList} abstract class as a base code.
 * 
 * <h3>OrderedArrayList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedListADT
 * @see ArrayList
 */
public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T> {
    /**
     * Constructs an empty OrderedArrayList with a default capacity.
     */
    public OrderedArrayList() {
        super();
    }

    /**
     * Constructs an empty OrderedArrayList with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException   {@inheritDoc}
     */
    @Override
    public void add(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");
        if (size() == array.length)
            expandCapacity();
        int insertionIndex = findInsertionIndex(element);
        for (int i = size(); i > insertionIndex; i--)
            array[i] = array[i - 1];
        array[insertionIndex] = element;
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException  {@inheritDoc}
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException      {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void set(int index, T element) {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (element == null)
            throw new NullPointerException("Element is null");
        T oldElement = array[index];
        if (((Comparable<T>) element).compareTo(oldElement) == 0) {
            array[index] = element;
            return;
        }
        for (int i = index; i < size() - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        int newIndex = findInsertionIndex(element);
        for (int i = size; i > newIndex; i--) {
            array[i] = array[i - 1];
        }
        array[newIndex] = element;
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException   if the elements in this list aren't comparable
     */
    public boolean contains(T target) {
        return BinarySearch.search(array, size(), target);
    }

    /**
     * Finds the index at which the specified element should be inserted to maintain
     * the order of the list.
     * 
     * @param element the specified element
     * @return the index at which the specified element should be inserted
     * @throws ClassCastException if the element isn't comparable
     */
    @SuppressWarnings("unchecked")
    private int findInsertionIndex(T element) {
        int left = 0;
        int right = size() - 1;
        Comparable<T> comparableElement = (Comparable<T>) element;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (comparableElement.compareTo(array[mid]) <= 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
