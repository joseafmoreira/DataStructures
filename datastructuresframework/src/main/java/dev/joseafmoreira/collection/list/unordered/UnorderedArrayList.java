package dev.joseafmoreira.collection.list.unordered;

import dev.joseafmoreira.algorithm.search.LinearSearch;
import dev.joseafmoreira.collection.list.ArrayList;
import pt.ipp.estg.ed.abstractdatatype.UnorderedListADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Resizable-array implementation of the {@code UnorderedListADT} interface
 * using the {@code ArrayList} abstract class as a base code.
 * 
 * <h3>UnorderedArrayList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see UnorderedListADT
 * @see ArrayList
 */
public class UnorderedArrayList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    /**
     * Constructs an empty UnorderedArrayList with a default capacity.
     */
    public UnorderedArrayList() {
        super();
    }

    /**
     * Constructs an empty UnorderedArrayList with a specified initial capacity.
     * 
     * @param initialCapacity the initial capacity (Minimum value is 0)
     */
    public UnorderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@inheritDoc}
     * 
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException      {@inheritDoc}
     */
    public void add(int index, T element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds");
        if (element == null)
            throw new NullPointerException("Element is null");
        if (size() == array.length)
            expandCapacity();
        for (int i = size(); i > index; i--)
            array[i] = array[i - 1];
        array[index] = element;
        size++;
        modCount++;
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
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
        return LinearSearch.search(array, size(), target);
    }
}
