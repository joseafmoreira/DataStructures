package dev.joseafmoreira.node;

/**
 * A heap node is an auxiliary object used in a linked implementation of a heap
 * abstract data type.
 * It contains a pointer to the {@link #parent} node.
 * <p>
 * This object uses the {@code BinaryTreeNode} object as a base implementation.
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #HeapNode()}: Constructs an empty heap node</li>
 * <li>{@link #HeapNode(Object)}: Constructs a heap node with an element</li>
 * <li>
 * {@link #HeapNode(Object, HeapNode, HeapNode, HeapNode)}:
 * Constrcuts a heap node with an element, a reference to the parent, left and
 * right children of this heap node
 * </li>
 * </ul>
 * 
 * The operations for this {@code HeapNode} include:
 * <p>
 * <ul>
 * <li>{@link #getParent()}: Returns the reference stored in this heap node
 * parent pointer</li>
 * <li>{@link #setParent(HeapNode)}: Sets the reference stored in this heap node
 * parent pointer</li>
 * <li>{@link #getLeft()}: Returns the reference stored in this heap node left
 * pointer</li>
 * <li>{@link #setLeft(HeapNode)}: Sets the reference stored in this heap node
 * left pointer</li>
 * <li>{@link #getRight()}: Returns the reference stored in this heap node right
 * pointer</li>
 * <li>{@link #setRight(HeapNode)}: Sets the reference stored in this heap node
 * right pointer</li>
 * <li>{@link #hashCode()}: Returns the hash code value for this heap node</li>
 * <li>{@link #equals(Object)}: Compares this heap node with the specified
 * object for equality</li>
 * </ul>
 * 
 * <h3>BinaryTreeNode</h3>
 * 
 * @param <T> the type of element stored in this heap node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see BinaryTreeNode
 */
public class HeapNode<T> extends BinaryTreeNode<T> {
    /**
     * A pointer to the parent of this heap node
     */
    protected HeapNode<T> parent;

    /**
     * Constructs an empty HeapNode object.
     */
    public HeapNode() {
        this(null);
    }

    /**
     * Constructs a heap node with an element.
     * 
     * @param element the element to be stored in this heap node
     */
    public HeapNode(T element) {
        this(element, null, null, null);
    }

    /**
     * Constrcuts a heap node with an element, a reference to the parent, left and
     * right
     * children of this heap node.
     * 
     * @param element the element to be stored in this heap node
     * @param parent  the reference to the parent of this heap node
     * @param left    the reference to the left child of this heap node
     * @param right   the reference to the right child of this heap node
     */
    public HeapNode(T element, HeapNode<T> parent, HeapNode<T> left, HeapNode<T> right) {
        super(element, left, right);
        setParent(parent);
    }

    /**
     * Returns the reference stored in this heap node parent pointer.
     * 
     * @return the reference stored in this heap node parent pointer
     */
    public HeapNode<T> getParent() {
        return parent;
    }

    /**
     * Sets the reference stored in this heap node parent pointer.
     * 
     * @param left the reference to be stored in this heap node parent pointer
     */
    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }

    /**
     * Returns the reference stored in this heap node left pointer.
     * 
     * @return the reference stored in this heap node left pointer
     */
    public HeapNode<T> getLeft() {
        return (HeapNode<T>) super.getLeft();
    }

    /**
     * Sets the reference stored in this heap node left pointer.
     * 
     * @param left the reference to be stored in this heap node left pointer
     */
    public void setLeft(HeapNode<T> left) {
        super.setLeft(left);
    }

    /**
     * Returns the reference stored in this heap node right pointer.
     * 
     * @return the reference stored in this heap node right pointer
     */
    public HeapNode<T> getRight() {
        return (HeapNode<T>) super.getRight();
    }

    /**
     * Sets the reference stored in this heap node right pointer.
     * 
     * @param right the reference to be stored in this heap node right pointer
     */
    public void setRight(HeapNode<T> right) {
        super.setRight(right);
    }
}
