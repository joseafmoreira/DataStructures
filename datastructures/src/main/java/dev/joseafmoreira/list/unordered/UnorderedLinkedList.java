package dev.joseafmoreira.list.unordered;

import dev.joseafmoreira.adts.UnorderedListADT;
import dev.joseafmoreira.list.LinkedList;
import dev.joseafmoreira.node.Node;

import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.ListADT;

/**
 * <h2>
 * UnorderedLinkedList
 * </h2>
 * <p>
 * The {@code UnorderedLinkedList} class that implements both the {@link UnorderedListADT UnorderedListADT} and {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code UnorderedLinkedList} is implemented using the {@link LinkedList LinkedList} abstract class as the base {@link ListADT ListADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class UnorderedLinkedList<T> extends LinkedList<T> implements UnorderedListADT<T> {
    /**
     * Instantiate an empty UnorderedLinkedList object
     */
    public UnorderedLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToFront(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element can't be null");

        add(head, element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToRear(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element can't be null");

        add(tail, element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAfter(T element, T target) throws NullPointerException, NoSuchElementException {
        if (element == null) throw new NullPointerException("Element can't be null");
        if (target == null) throw new NullPointerException("Target can't be null");

        Node<T> targetNode = head;
        while (targetNode != null) {
            if (targetNode.getElement().equals(target)) {
                add(targetNode, element);
                return;
            }
            targetNode = targetNode.getNext();
        }

        throw new NoSuchElementException("Target not found");
    }

    /**
     * Inserts the specified element after the specified node in this list.
     *
     * @param currentNode the node at which the specified element is to be inserted
     * @param element the element to be inserted
     */
    private void add(Node<T> currentNode, T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else if (currentNode == head) {
            newNode.setNext(currentNode);
            head = newNode;
        } else {
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            if (currentNode == tail) tail = newNode;
        }
        size++;
        modCount++;
    }
}
