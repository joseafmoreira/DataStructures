package dev.joseafmoreira.node;

/**
 * <h2>
 * Node
 * </h2>
 * <p>
 * The {@code Node} class that specified the behavior of a single linked node.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class Node<T> {
    /**
     * The element stored in this node
     */
    protected T element;
    /**
     * The pointer to the next node
     */
    protected Node<T> next;

    /**
     * Instantiate an empty Node object
     */
    public Node() {
        this(null, null);
    }

    /**
     * Instantiate a new node object with the specified element
     * 
     * @param element the specified element
     */
    public Node(T element) throws NullPointerException {
        this(element, null);
    }

    /**
     * Instantiate a new node object with the specified element and next node reference
     * 
     * @param element the specified element
     * @param next the next node's reference
     */
    public Node(T element, Node<T> next) {
        setElement(element);
        setNext(next);
    }

    /**
     * Returns the element stored in this node.
     *
     * @return the element stored in this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element of this node.
     * 
     * @param element the new element to be set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the reference to the next node stored in this node.
     *
     * @return the reference to the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node of this node.
     * 
     * @param next the next node's reference
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Returns a string representation of this node.
     *
     * @return a string representation of this node.
     */
    @Override
    public String toString() {
        return element.toString();
    }
}
