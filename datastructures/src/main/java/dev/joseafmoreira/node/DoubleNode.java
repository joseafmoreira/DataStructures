package dev.joseafmoreira.node;

/**
 * <h2>
 * DoubleNode
 * </h2>
 * <p>
 * The {@code DoubleNode} class that specified the behavior of a double linked node.
 * </p>
 * <p>
 * The {@code DoubleNode} class extends the {@link Node single linked node} class.
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class DoubleNode<T> extends Node<T> {
    /**
     * The pointer to the previous node
     */
    protected DoubleNode<T> prev;

    /**
     * Instantiate an empty DoubleNode object
     */
    public DoubleNode() {
        this(null, null, null);
    }

    /**
     * Instantiate a new double node object with the specified element
     * 
     * @param element the specified element
     */
    public DoubleNode(T element) {
        this(element, null, null);
    }

    /**
     * Instantiate a new double node object with the specified element, next node reference and previous node reference
     * 
     * @param element the specified element
     * @param next the next node's reference
     * @param next the previous node's reference
     */
    public DoubleNode(T element, DoubleNode<T> next, DoubleNode<T> prev) {
        super(element, next);
        setPrev(prev);
    }

    /**
     * Returns the reference to the next node stored in this node.
     *
     * @return the reference to the next node
     */
    public DoubleNode<T> getNext() {
        return (DoubleNode<T>) super.getNext();
    }

    /**
     * Sets the next node of this node.
     * 
     * @param next the next node's reference
     */
    public void setNext(DoubleNode<T> next) {
        super.setNext((Node<T>) next);
    }

    /**
     * Returns the reference to the previous node stored in this node.
     *
     * @return the reference to the previous node
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node of this node.
     * 
     * @param next the previous node's reference
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
