package dev.joseafmoreira.node;

/**
 * A linear node is an auxiliary object used to implement a single linked
 * abstract data type.
 * It contains an {@code #element} and a pointer to the {@code #next} linear
 * node.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #LinearNode()}: Constructs an empty linear node</li>
 * <li>{@link #LinearNode(Object)}: Constructs a linear node with an
 * element</li>
 * <li>{@link #LinearNode(Object, LinearNode)}: Constructs a linear node with an
 * element and a reference to the next linear node</li>
 * </ul>
 * 
 * The operations for this {@code LinearNode} include:
 * <p>
 * <ul>
 * <li>{@link #getNext()}: Returns the reference stored in this linear node next
 * pointer</li>
 * <li>{@link #setNext(LinearNode)}: Sets the reference stored in this linear
 * node next pointer</li>
 * </ul>
 * 
 * <h3>LinearNode</h3>
 * 
 * @param <T> the type of element stored in this linear node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see Node
 */
public class LinearNode<T> extends Node<T> {
    /**
     * The pointer to the next linear node
     */
    protected LinearNode<T> next;

    /**
     * Constructs an empty linear node.
     */
    public LinearNode() {
        this(null);
    }

    /**
     * Constructs a linear node with an element.
     * 
     * @param element the element to be stored in this linear node
     */
    public LinearNode(T element) {
        this(element, null);
    }

    /**
     * Constrcuts a linear node with an element and a reference to the next linear
     * node.
     * 
     * @param element the element to be stored in this linear node
     * @param next    the reference of the next linear node
     */
    public LinearNode(T element, LinearNode<T> next) {
        super(element);
        setNext(next);
    }

    /**
     * Returns the reference stored in this linear node next pointer.
     * 
     * @return the reference stored in this linear node next pointer
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Sets the reference stored in this linear node next pointer.
     * 
     * @param next the reference to be stored in this linear node next pointer
     */
    public void setNext(LinearNode<T> next) {
        this.next = next;
    }
}
