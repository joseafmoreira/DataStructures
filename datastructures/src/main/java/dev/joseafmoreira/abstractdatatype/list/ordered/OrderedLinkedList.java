package dev.joseafmoreira.abstractdatatype.list.ordered;

import dev.joseafmoreira.abstractdatatype.list.LinkedList;
import dev.joseafmoreira.node.LinearNode;
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

        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty() || comparableElement.compareTo(head.getElement()) < 0) {
            head = new LinearNode<>(element, head);
            if (isEmpty())
                tail = head;
        } else if (comparableElement.compareTo(tail.getElement()) >= 0) {
            LinearNode<T> newNode = new LinearNode<>(element);
            tail.setNext(newNode);
            tail = newNode;
            size++;
            modCount++;
        } else {
            LinearNode<T> previousNode = head;
            LinearNode<T> currentNode = head.getNext();
            while (currentNode != null && comparableElement.compareTo(currentNode.getElement()) >= 0) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            LinearNode<T> newNode = new LinearNode<>(element, currentNode);
            previousNode.setNext(newNode);
        }
        size++;
        modCount++;
    }
}
