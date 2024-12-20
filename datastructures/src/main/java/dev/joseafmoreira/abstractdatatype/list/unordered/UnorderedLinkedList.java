package dev.joseafmoreira.abstractdatatype.list.unordered;

import java.util.NoSuchElementException;

import dev.joseafmoreira.abstractdatatype.list.LinkedList;
import dev.joseafmoreira.node.LinearNode;
import pt.ipp.estg.ed.UnorderedListADT;

/**
 * Singly-linked list implementation of the {@code UnorderedListADT} interface.
 * 
 * <h3>UnorderedLinkedList</h3>
 * 
 * @param <T> the type of element stored in this unordered list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see UnorderedListADT
 * @see LinkedList
 */
public class UnorderedLinkedList<T> extends LinkedList<T> implements UnorderedListADT<T> {
    /**
     * Constructs an empty UnorderedLinkedList object.
     */
    public UnorderedLinkedList() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element is null
     */
    @Override
    public void addToFront(T element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Element is null");

        head = new LinearNode<>(element, head);
        if (isEmpty())
            tail = head;
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element is null
     */
    @Override
    public void addToRear(T element) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Element is null");

        if (isEmpty())
            addToFront(element);
        else {
            LinearNode<T> newNode = new LinearNode<>(element);
            tail.setNext(newNode);
            tail = newNode;
            size++;
            modCount++;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the element or target are null
     */
    @Override
    public void addAfter(T element, T target) throws NullPointerException {
        if (element == null)
            throw new NullPointerException("Element is null");
        if (target == null)
            throw new NullPointerException("Target is null");

        if (first().equals(target))
            addToFront(element);
        else if (last().equals(target))
            addToRear(element);
        else if (size() > 2) {
            LinearNode<T> currentNode = head.getNext();
            while (currentNode != tail) {
                if (currentNode.getElement().equals(target)) {
                    LinearNode<T> newNode = new LinearNode<>(element, currentNode.getNext());
                    currentNode.setNext(newNode);
                    size++;
                    modCount++;
                }
                currentNode = currentNode.getNext();
            }
        }

        throw new NoSuchElementException("Target not found");
    }
}
