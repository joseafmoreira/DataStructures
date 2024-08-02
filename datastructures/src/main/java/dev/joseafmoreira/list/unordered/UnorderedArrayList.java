package dev.joseafmoreira.list.unordered;

import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.adts.UnorderedListADT;
import dev.joseafmoreira.list.ArrayList;

/**
 * <h2>
 * UnorderedArrayList
 * </h2>
 * <p>
 * The {@code UnorderedArrayList} class that implements both the {@link UnorderedListADT UnorderedListADT} and {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code UnorderedArrayList} is implemented using the {@link ArrayList ArrayList} abstract class as the base {@link ListADT ListADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class UnorderedArrayList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    /**
     * Instantiate an empty UnorderedArrayList object
     */
    public UnorderedArrayList() {
        super();
    }

    /**
     * Instantiate an empty UnorderedArrayList with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    public UnorderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToFront(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element is null");
        
        add(0, element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToRear(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element is null");
        
        add(size(), element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAfter(T element, T target) throws NullPointerException, NoSuchElementException {
        if (element == null) throw new NullPointerException("Element is null");
        if (target == null) throw new NullPointerException("Target is null");
        
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(target)) {
                add(i + 1, element);
                return;
            }
        }

        throw new NoSuchElementException("Target not found");
    }
    
    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param targetIndex the index at which the specified element is to be inserted
     * @param element the element to be inserted
     */
    private void add(int targetIndex, T element) {
        if (size() == array.length) expandCapacity();
        for (int i = size(); i > targetIndex; i--) array[i] = array[i - 1];
        array[targetIndex] = element;
        size++;
        modCount++;
    }
}
