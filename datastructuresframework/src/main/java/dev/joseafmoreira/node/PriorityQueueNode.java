package dev.joseafmoreira.node;

/**
 * A priority queue node is an auxiliary object used to implement a priority
 * queue.
 * It contains an {@link #element}.
 * <p>
 * 
 * The available constructors are the following:
 * <p>
 * <ul>
 * <li>{@link #PriorityQueueNode()}: Constructs an empty priority queue
 * node</li>
 * <li>{@link #PriorityQueueNode(Object)}: Constructs a priority queue node with
 * an
 * element</li>
 * <li>{@link #PriorityQueueNode(Object, int)}: Constructs a priority queue node
 * with an
 * element and a priority</li>
 * </ul>
 * 
 * The operations for this {@code PriorityQueueNode} include:
 * <p>
 * <ul>
 * <li>{@link #getPriority()}: Returns the priority of this priority queue
 * node</li>
 * <li>{@link #setPriority(int)}: Sets the priority in this priority queue
 * node</li>
 * <li>{@link #getOrder()}: Returns the order of this priority queue node</li>
 * <li>{@link #getElement()}: Returns the element stored in this priority queue
 * node</li>
 * <li>{@link #setElement(Object)}: Sets the element stored in this priority
 * queue node</li>
 * <li>{@link #compareTo(PriorityQueueNode)}: Compares this PriorityQueueNode
 * with the specified PriorityQueueNode for order.</li>
 * <li>{@link #toString()}: Returns a string representation of this priority
 * queue
 * node</li>
 * </ul>
 * 
 * <h3>PriorityQueueNode</h3>
 * 
 * @param <T> the type of element stored in this priority queue node
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 */
public class PriorityQueueNode<T> implements Comparable<PriorityQueueNode<T>> {
    /**
     * The order that is attributed to all new PriorityQueueNode instances
     */
    private static int NEXT_ORDER = 0;
    /**
     * The order stored in this priority queue node
     */
    private final int order;
    /**
     * The element stored in this priority queue node
     */
    private T element;
    /**
     * The priority stored in this priority queue node
     */
    private int priority;

    /**
     * Constructs an empty priority queue node.
     */
    public PriorityQueueNode() {
        this(null);
    }

    /**
     * Constructs a priority queue node with an element.
     * 
     * @param element the element to be stored in this priority queue node
     */
    public PriorityQueueNode(T element) {
        this(element, 0);
    }

    /**
     * Constructs a priority queue node with an element and a priority.
     * 
     * @param element  the element to be stored in this priority queue node
     * @param priority the priority to be stored in this priority queue node
     */
    public PriorityQueueNode(T element, int priority) {
        order = NEXT_ORDER++;
        setElement(element);
        setPriority(priority);
    }

    /**
     * Returns the priority of this priority queue node.
     * 
     * @return the priority of this priority queue node
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority in this priority queue node.
     * 
     * @param priority the priority to be stored in this priority queue node
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Returns the order stored in this priority queue node.
     * 
     * @return the order stored in this priority queue node
     */
    public int getOrder() {
        return order;
    }

    /**
     * Returns the element stored in this priority queue node.
     * 
     * @return the element stored in this priority queue node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this priority queue node.
     * 
     * @param element the element to be stored in this priority queue node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Compares this PriorityQueueNode with the specified PriorityQueueNode for
     * order.
     * Returns a negative integer, zero, or a positive integer as this object's
     * priority
     * is less than, equal to, or greater than the specified object's priority.
     * If the priorities are equal, it compares the order of the nodes.
     *
     * @param o the PriorityQueueNode to be compared.
     * @return a negative integer, zero, or a positive integer as this object's
     *         priority
     *         is less than, equal to, or greater than the specified object's
     *         priority.
     */
    @Override
    public int compareTo(PriorityQueueNode<T> o) {
        if (priority > o.priority)
            return 1;
        else if (priority < o.priority)
            return -1;
        else {
            int result = 0;
            if (order > o.order)
                result = 1;
            else if (order < o.order)
                result = -1;

            return result;
        }
    }

    /**
     * Returns a string representation of this priority queue node.
     * 
     * @return a string representation of this priority queue node
     */
    @Override
    public String toString() {
        return element.toString();
    }
}
