package dev.joseafmoreira.abstractdatatype.list.ordered;

import dev.joseafmoreira.abstractdatatype.list.DoubleLinkedList;
import pt.ipp.estg.ed.OrderedListADT;

/**
 * Doubly-linked list implementation of the {@code OrderedListADT} interface.
 * 
 * <h3>OrderedDoubleLinkedList</h3>
 * @param <T> the type of element stored in this ordered list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedListADT
 * @see DoubleLinkedList
 */
public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
    /**
     * Constructs an empty OrderedDoubleLinkedList object.
     */
    public OrderedDoubleLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element is null
     * @throws ClassCastException if the element isn't comparable
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) throws NullPointerException, ClassCastException {
        if (element == null) throw new NullPointerException("Element is null");

        
    }
}
