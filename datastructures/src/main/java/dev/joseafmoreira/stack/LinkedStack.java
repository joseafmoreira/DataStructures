package dev.joseafmoreira.stack;

import dev.joseafmoreira.adts.StackADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.node.Node;

/**
 * <h2>
 * LinkedStack
 * </h2>
 * <p>
 * The <code>LinkedStack</code> class that implements {@link StackADT StackADT} interface.
 * </p>
 * <p>
 * The <code>LinkedStack</code> is implemented using linked {@link Node nodes}
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class LinkedStack<T> implements StackADT<T> {
    /**
     * This represents the head node of this stack
     */
    protected Node<T> head;
    /**
     * This represents the number of elements in this stack
     */
    protected int size;

    /**
     * Instantiate an empty LinkedStack object
     */
    public LinkedStack() {
        head = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException("Element can't be null");

        head = new Node<>(element, head);
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() throws EmptyCollectionException {
        T result = peek();
        head = head.getNext();
        size--;

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Stack is empty");

        return head.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        result.append(inverseToStringOrder(head));
        result.append("]");

        return result.toString();
    }

    /**
     * Returns a string representation of the elements in the stack in inverse order.
     * The elements are concatenated with commas between them.
     *
     * @param currentNode the current node being processed
     * @return a string representation of the elements in inverse order
     */
    private String inverseToStringOrder(Node<T> currentNode) {
        if (currentNode == null) return "";

        return inverseToStringOrder(currentNode.getNext()) + ((currentNode.getNext() == null) ? "" : ", ") + currentNode.getElement();
    }
}
