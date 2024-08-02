package dev.joseafmoreira.list.ordered;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.adts.OrderedListADT;
import dev.joseafmoreira.list.ArrayList;

/**
 * <h2>
 * OrderedArrayList
 * </h2>
 * <p>
 * The {@code OrderedArrayList} class that implements both the {@link OrderedListADT OrderedListADT} and {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code OrderedArrayList} is implemented using the {@link ArrayList ArrayList} abstract class as the base {@link ListADT ListADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T> {
    /**
     * Instantiate an empty OrderedArrayList object
     */
    public OrderedArrayList() {
        super();
    }

    /**
     * Instantiate an empty OrderedArrayList with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) throws NullPointerException, ClassCastException {
        if (element == null) throw new NullPointerException("Element is null");
        if (size() == array.length) expandCapacity();
        
        Comparable<T> comparableElement = (Comparable<T>) element;
        int targetIndex = 0;
        while (targetIndex < size() && comparableElement.compareTo(array[targetIndex]) > 0) targetIndex++;
        for (int i = size(); i > targetIndex; i--) array[i] = array[i - 1];
        array[targetIndex] = element;
        size++;
        modCount++;
    }
}
