package dev.joseafmoreira.abstractdatatype.list.ordered;

import dev.joseafmoreira.abstractdatatype.list.LinkedList;
import pt.ipp.estg.ed.OrderedListADT;

/**
 * Singly-linked list implementation of the {@code OrderedListADT} interface.
 * 
 * <h3>OrderedLinkedList</h3>
 * @param <T> the type of element stored in this ordered list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see OrderedListADT
 * @see LinkedList
 */
public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T> {
    /**
     * Constructs an empty OrderedLinkedList object.
     */
    public OrderedLinkedList() {
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
