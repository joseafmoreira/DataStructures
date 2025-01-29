package dev.joseafmoreira.collection.stack;

import dev.joseafmoreira.collection.AbstractLinkedListCollection;
import dev.joseafmoreira.node.LinearNode;
import pt.ipp.estg.ed.abstractdatatype.StackADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Singly-linked list implementation of the {@code StackADT} interface.
 * 
 * <h3>LinkedStack</h3>
 * 
 * @param <T> the type of element stored in this stack
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractLinkedListCollection
 * @see StackADT
 */
public class LinkedStack<T> extends AbstractLinkedListCollection<T> implements StackADT<T> {
    /**
     * Constructs an empty LinkedStack object.
     */
    public LinkedStack() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void push(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");

        head = new LinearNode<>(element, head);
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T pop() {
        T result = peek();
        head = head.getNext();
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyCollectionException("Stack is empty");

        return head.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return (new StringBuilder("[" + reverseToString(head) + "]")).toString();
    }

    /**
     * Recursively converts the elements of this stack to a string in reverse order.
     * 
     * @param currentNode the current node
     * @return a string representation of the elements of this stack in reverse
     *         order
     */
    private String reverseToString(LinearNode<T> currentNode) {
        if (currentNode == null)
            return "";

        return reverseToString(currentNode.getNext()) + ((currentNode.getNext() == null) ? "" : ", ")
                + currentNode.getElement();
    }
}
