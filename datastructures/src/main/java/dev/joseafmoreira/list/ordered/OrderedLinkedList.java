package dev.joseafmoreira.list.ordered;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.adts.OrderedListADT;
import dev.joseafmoreira.list.LinkedList;
import dev.joseafmoreira.node.Node;

/**
 * <h2>
 * OrderedLinkedList
 * </h2>
 * <p>
 * The {@code OrderedLinkedList} class that implements both the {@link OrderedListADT OrderedListADT} and {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code OrderedLinkedList} is implemented using the {@link LinkedList LinkedList} abstract class as the base {@link ListADT ListADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T> {
    /**
     * Instantiate an empty OrderedLinkedList object
     */
    public OrderedLinkedList() {
        super();
    }

    /**
     * Adds the specified element to this list in a sorted manner.
     * The element is inserted at the correct position to maintain the list's order.
     *
     * @param element the element to be added to this list
     * @throws NullPointerException if the specified element is null
     * @throws ClassCastException if the specified element isn't comparable
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) throws NullPointerException, ClassCastException {
        if (element == null) throw new NullPointerException("Element can't be null");

        Comparable<T> comparableElement = (Comparable<T>) element;
        Node<T> newNode = new Node<>(element);
        if (isEmpty() || comparableElement.compareTo(head.getElement()) <= 0) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) tail = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null && comparableElement.compareTo(currentNode.getNext().getElement()) > 0) currentNode = currentNode.getNext();
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            if (newNode.getNext() == null) tail = newNode;
        }
        size++;
        modCount++;
    }
}
