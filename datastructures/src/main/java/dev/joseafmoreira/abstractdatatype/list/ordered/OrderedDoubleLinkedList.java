package dev.joseafmoreira.abstractdatatype.list.ordered;

import dev.joseafmoreira.abstractdatatype.list.DoubleLinkedList;
import dev.joseafmoreira.node.DoubleLinearNode;
import pt.ipp.estg.ed.OrderedListADT;

/**
 * Doubly-linked list implementation of the {@code OrderedListADT} interface.
 * 
 * <h3>OrderedDoubleLinkedList</h3>
 * 
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
     * @throws ClassCastException   if the element isn't comparable
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) throws NullPointerException, ClassCastException {
        if (element == null)
            throw new NullPointerException("Element is null");

        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty() || comparableElement.compareTo(head.getElement()) < 0) {
            head = new DoubleLinearNode<>(element, null, head);
            if (head.getNext() != null)
                head.getNext().setPrev(head);
            if (isEmpty())
                tail = head;
        } else if (comparableElement.compareTo(tail.getElement()) >= 0) {
            DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            DoubleLinearNode<T> currentNode = head.getNext();
            while (currentNode != null && comparableElement.compareTo(currentNode.getElement()) >= 0)
                currentNode = currentNode.getNext();
            DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element, currentNode.getPrev(), currentNode);
            currentNode.getPrev().setNext(newNode);
            currentNode.setPrev(newNode);
        }
        size++;
        modCount++;
    }
}
