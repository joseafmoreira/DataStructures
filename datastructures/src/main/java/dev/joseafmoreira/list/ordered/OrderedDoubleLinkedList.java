package dev.joseafmoreira.list.ordered;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.adts.OrderedListADT;
import dev.joseafmoreira.list.DoubleLinkedList;
import dev.joseafmoreira.node.DoubleNode;

/**
 * <h2>
 * OrderedDoubleLinkedList
 * </h2>
 * <p>
 * The {@code OrderedDoubleLinkedList} class that implements both the {@link OrderedListADT OrderedListADT} and {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code OrderedDoubleLinkedList} is implemented using the {@link DoubleLinkedList DoubleLinkedList} abstract class as the base {@link ListADT ListADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
    /**
     * Instantiate an empty OrderedDoubleLinkedList object
     */
    public OrderedDoubleLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(T element) throws NullPointerException, ClassCastException {
        if (element == null) throw new NullPointerException("Element is null");

        Comparable<T> comparableElement = (Comparable<T>) element;
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (isEmpty() || comparableElement.compareTo(head.getElement()) <= 0) {
            newNode.setNext(head);
            if (head != null) head.setPrev(newNode);
            else tail = newNode;
            head = newNode;
        } else {
            DoubleNode<T> currentNode = head;
            while (currentNode.getNext() != null && comparableElement.compareTo(currentNode.getNext().getElement()) > 0) currentNode = currentNode.getNext();
            newNode.setNext(currentNode.getNext());
            if (currentNode.getNext() != null) currentNode.getNext().setPrev(newNode);
            else tail = newNode;
            newNode.setPrev(currentNode);
            currentNode.setNext(newNode);
        }
        size++;
        modCount++;
    }
}
