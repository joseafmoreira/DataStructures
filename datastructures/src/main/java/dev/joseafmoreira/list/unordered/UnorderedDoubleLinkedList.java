package dev.joseafmoreira.list.unordered;

import dev.joseafmoreira.adts.UnorderedListADT;
import dev.joseafmoreira.list.DoubleLinkedList;
import dev.joseafmoreira.node.DoubleNode;

import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.ListADT;

/**
 * <h2>
 * UnorderedDoubleLinkedList
 * </h2>
 * <p>
 * The {@code UnorderedDoubleLinkedList} class that implements both the {@link UnorderedListADT UnorderedListADT} and {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code UnorderedDoubleLinkedList} is implemented using the {@link DoubleLinkedList LinkedList} abstract class as the base {@link ListADT ListADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
    /**
     * Instantiate an empty UnorderedDoubleLinkedList object
     */
    public UnorderedDoubleLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addToFront(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element can't be null");

        add(null, element);
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

        DoubleNode<T> targetNode = head;
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
    private void add(DoubleNode<T> currentNode, T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (currentNode == null) {
            newNode.setNext(head);
            if (head != null) head.setPrev(newNode);
            else tail = newNode;
            head = newNode;
        } else {
            newNode.setNext(currentNode.getNext());
            newNode.setPrev(currentNode);
            if (currentNode.getNext() != null) currentNode.getNext().setPrev(newNode);
            else tail = newNode;
            currentNode.setNext(newNode);
        }
    }
}
