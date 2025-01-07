package pt.ipp.estg.ed;

/**
 * A stack is a linear abstract data type that follows the Last In, First Out (LIFO) principle 
 * meaning that the last element added to this stack will be the first one to be removed from it. <p>
 * 
 * The common operations for a stack include: <p>
 * <ul>
 *  <li>{@link #push(Object)}: Adds an element to the top of this stack</li>
 *  <li>{@link #pop()}: Removes an element from the top of this stack</li>
 *  <li>{@link #peek()}: Returns the element from the top of this stack</li>
 * </ul>
 * 
 * This interface is a member of the 
 * <i>Data Structures Framework</i>
 * 
 * <h3>StackADT</h3>
 * @param <T> the type of elements in this stack
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 */
public interface StackADT<T> extends ADT<T> {
    /**
     * Adds an element to the top of this stack.
     * 
     * @param element the element to be added
     */
    void push(T element);

    /**
     * Removes an element from the top of this stack.
     * 
     * @return the element from the top of this stack
     */
    T pop();

    /**
     * Returns the element from the top of this stack.
     * 
     * @return the element from the top of this stack
     */
    T peek();
}
