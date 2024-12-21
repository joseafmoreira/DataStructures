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
 * <li>{@link #getElement()}: Returns the element stored in this priority queue
 * node</li>
 * <li>{@link #setElement(Object)}: Sets the element stored in this priority
 * queue
 * node</li>
 * <li>{@link #compareTo(PriorityQueueNode)}:</li>
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
    private static int NEXT_ORDER = 0;
    private int order;
    private T element;
    private int priority;

    public PriorityQueueNode() {
        this(null);
    }

    public PriorityQueueNode(T element) {
        this(element, 0);
    }

    public PriorityQueueNode(T element, int priority) {
        setOrder(NEXT_ORDER++);
        setElement(element);
        setPriority(priority);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

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

    @Override
    public String toString() {
        return element.toString();
    }
}
