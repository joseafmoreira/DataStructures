package pt.ipp.estg.ed.abstractdatatype;

import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * A binary search tree is a non-linear abstract data type that all elements are stored 
 * so that, for every parent node, the left child will be smaller and 
 * the right child child will be bigger than the parent node element. <p>
 * With this definition, it can be stated that 
 * the minimum element will be the leftmost node and  
 * the maximum element will be the rightmost node in the binary search tree <p>
 * 
 * The common operations for a binary search tree include: <p>
 * <ul>
 *  <li>{@link #add(Object)}: Adds an element to this binary search tree at the proper location</li>
 *  <li>{@link #findMin()}: Returns the element from the leftmost node in this binary search tree</li>
 *  <li>{@link #findMax()}: Returns the element from the rightmost node in this binary search tree</li>
 *  <li>{@link #remove(Object)}: Removes a specified element from this binary search tree</li>
 *  <li>{@link #removeAllOccurrences(Object)}: Removes all occurrences of a specified element from this binary search tree</li>
 *  <li>{@link #removeMin()}: Removes the element from the leftmost node in this binary search tree</li>
 *  <li>{@link #removeMax()}: Removes the element from the rightmost node in this binary search tree</li>
 * </ul>
 * 
 * This interface is a member of the 
 * <i>Data Structures Framework</i>
 * 
 * <h3>BinarySearchTreeADT</h3>
 * @param <T> the type of elements in this binary search tree
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 * @see BinaryTreeADT
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    /**
     * Adds an element to this binary search tree at the proper location.
     * 
     * @param element the element to be added
     * @throws NullPointerException if the specified element is null and
     *         this binary tree does not allow null elements
     */
    void add(T element);

    /**
     * Returns the element from the leftmost node in this binary search tree.
     * 
     * @return the element from the leftmost node in this binary search tree
     * @throws EmptyCollectionException if this binary tree is empty
     */
    T findMin();

    /**
     * Returns the element from the rightmost node in this binary search tree.
     * 
     * @return the element from the rightmost node in this binary search tree
     * @throws EmptyCollectionException if this binary tree is empty
     */
    T findMax();

    /**
     * Removes a specified element from this binary search tree.
     * 
     * @param target the target to remove
     * @return the removed element
     * @throws NullPointerException if the specified target is null and
     *         this binary tree does not allow null elements
     * @throws EmptyCollectionException if this binary tree is empty
     * @throws IllegalArgumentException if the specified target is not 
     *         found in this binary tree
     */
    T remove(T target);

    /**
     * Removes all occurrences of a specified element from this binary search tree.
     * 
     * @param target the target to remove
     * @throws NullPointerException if the specified target is null and
     *         this binary tree does not allow null elements
     * @throws EmptyCollectionException if this binary tree is empty
     */
    default void removeAllOccurrences(T target) {
        while (true) {
            try {
                remove(target);
            } catch (IllegalArgumentException ignored) {
                break;
            }
        }
    }

    /**
     * Removes the element from the leftmost node in this binary search tree.
     * 
     * @return the element from the leftmost node in this binary search tree
     * @throws EmptyCollectionException if this binary tree is empty
     */
    default T removeMin() {
        return remove(findMin());
    }

    /**
     * Removes the element from the rightmost node in this binary search tree.
     * 
     * @return the element from the rightmost node in this binary search tree
     * @throws EmptyCollectionException if this binary tree is empty
     */
    default T removeMax() {
        return remove(findMax());
    }
}
