package dev.joseafmoreira.collection.list.ordered;

import dev.joseafmoreira.collection.list.ArrayList;
import pt.ipp.estg.ed.abstractdatatype.OrderedListADT;

/**
 * Resizable-array implementation of the {@code OrderedListADT} interface
 * using the {@code ArrayList} abstract class as a base code.
 * 
 * <h3>UnorderedArrayList</h3>
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
     * @throws ClassCastException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");
        if (size() == array.length)
            expandCapacity();
        int addingIndex = size();
        Comparable<T> comparableElement = (Comparable<T>) element;
        for (int i = 0; i < size(); i++) {
            if (comparableElement.compareTo(array[i]) <= 0) {
                for (int j = size(); j > i; j--)
                    array[j] = array[j - 1];
                addingIndex = i;
                break;
            }
        }
        array[addingIndex] = element;
        size++;
        modCount++;
    }
}
