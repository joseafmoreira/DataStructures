package dev.joseafmoreira.node;

/**
 * A node is an auxiliary object used to store an {@code #element}.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #Node()}: Constructs an empty node</li>
 * <li>{@link #Node(Object)}: Constructs a node with an
 * element</li>
 * </ul>
 * 
 * The operations for this {@code Node} include:
 * <p>
 * <ul>
 * <li>{@link #getElement()}: Returns the element stored in this
 * node</li>
 * <li>{@link #setElement(Object)}: Sets the element stored in this
 * node</li>
 * node next pointer</li>
 * <li>{@link #hashCode()}: Returns the hash code value for this
 * node</li>
 * <li>{@link #equals(Object)}: Compares this node with the specified
 * object for equality</li>
 * <li>{@link #toString()}: Returns a string representation of this
 * node</li>
 * </ul>
 * 
 * <h3>Node</h3>
 * 
 * @param <T> the type of element stored in this node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public abstract class Node<T> {
    /**
     * The prime number used to create an hash code for this node and all
     * it's subclasses
     */
    protected static final int PRIME_NUMBER = 31;
    /**
     * The element stored in this node
     */
    protected T element;

    /**
     * Constructs an empty node.
     */
    public Node() {
        this(null);
    }

    /**
     * Constructs a node with an element.
     * 
     * @param element the element to be stored in this node
     */
    public Node(T element) {
        setElement(element);
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
     * Sets the element stored in this node.
     * 
     * @param element the element to be stored in this node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Compares this node with the specified object for equality.
     * 
     * @param obj the object to compare with
     * @return true if the specified object is equal to this node, false
     *         otherwise
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        LinearNode<T> other = (LinearNode<T>) obj;
        if (element == null && other.element != null || element != null && !element.equals(other.element))
            return false;

        return true;
    }

    /**
     * Returns the hash code value for this node.
     * The hash code is calculated based on the element node of this
     * node.
     * 
     * @return the hash code value for this node
     */
    @Override
    public int hashCode() {
        return PRIME_NUMBER * 1 + ((element == null) ? 0 : element.hashCode());
    }

    /**
     * Returns a string representation of this node.
     * 
     * @return a string representation of this node
     */
    @Override
    public String toString() {
        return element.toString();
    }
}
