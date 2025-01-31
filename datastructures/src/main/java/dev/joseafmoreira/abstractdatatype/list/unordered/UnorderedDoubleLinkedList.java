package dev.joseafmoreira.abstractdatatype.list.unordered;

import java.util.NoSuchElementException;

import dev.joseafmoreira.abstractdatatype.list.DoubleLinkedList;
import dev.joseafmoreira.node.DoubleLinearNode;
import pt.ipp.estg.ed.UnorderedListADT;

/**
 * Doubly-linked list implementation of the {@code UnorderedListADT} interface.
 * 
 * <h3>UnorderedDoubleLinkedList</h3>
 * 
 * @param <T> the type of element stored in this unordered list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see UnorderedListADT
 * @see DoubleLinkedList
 */
public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
    /**
     * Constructs an empty UnorderedDoubleLinkedList object.
     */
    public UnorderedDoubleLinkedList() {
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

        head = new DoubleLinearNode<>(element, null, head);
        if (head.getNext() != null)
            head.getNext().setPrev(head);
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
            DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element, tail, null);
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

        if (last().equals(target)) {
            addToRear(element);
            return;
        } else if (size() > 1) {
            DoubleLinearNode<T> currentNode = head;
            while (currentNode != tail) {
                if (currentNode.getElement().equals(target)) {
                    DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element, currentNode, currentNode.getNext());
                    currentNode.setNext(newNode);
                    newNode.getNext().setPrev(newNode);
                    size++;
                    modCount++;
                    return;
                }
                currentNode = currentNode.getNext();
            }
        }

        throw new NoSuchElementException("Target not found");
    }
}
