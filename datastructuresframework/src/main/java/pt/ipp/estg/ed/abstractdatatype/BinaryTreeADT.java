package pt.ipp.estg.ed.abstractdatatype;

import java.util.Iterator;

import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * A binary tree is a non-linear abstract data type that, based of the concept of a tree, 
 * every node, with the exception of the root node, has exactly one parent and, at max, 
 * two children.<p>
 * There will be three base types of binary trees implemented: <p>
 * <ul>
 *  <li>Search</li>
 *  <li>Min-heap</li>
 *  <li>Max-heap</li>
 * </ul>
 * For this interface, it's only specified the common operations between all binary trees leaving the 
 * unique methods for the search, the min-heap and the max-heap binary trees in the 
 * {@code BinarySearchTreeADT}, {@code MinHeapADT} and {@code MaxHeapADT} respectively
 * 
 * The common operations for a binary tree include: <p>
 * <ul>
 *  <li>{@link #getRoot()}: Returns the element from the root of this binary tree</li>
 *  <li>{@link #find(Object)}: Returns a specified element if it is found in this binary tree</li>
 *  <li>{@link #iteratorPreOrder()}: Returns an iterator over the elements in this binary tree by performing a pre-order traversal</li>
 *  <li>{@link #iteratorInOrder()}: Returns an iterator over the elements in this binary tree by performing an in-order traversal</li>
 *  <li>{@link #iteratorPostOrder()}: Returns an iterator over the elements in this binary tree by performing a post-order traversal</li>
 *  <li>{@link #iteratorLevelOrder()}: Returns an iterator over the elements in this binary tree by performing a level-order traversal</li>
 * </ul>
 * 
 * This interface is a member of the 
 * <i>Data Structures Framework</i>
 * 
 * <h3>BinaryTreeADT</h3>
 * @param <T> the type of elements in this binary tree
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 * @see BinarySearchTreeADT
 * @see MinHeapADT
 * @see MaxHeapADT
 * @see Iterator
 */
public interface BinaryTreeADT<T> extends IterableCollectionADT<T> {
    /**
     * Returns the element from the root of this binary tree.
     * 
     * @return the element from the root of this binary tree
     * @throws EmptyCollectionException if this binary tree is empty
     */
    T getRoot();

    /**
     * Returns a specified element if it is found in this binary tree.
     * 
     * @param target the target to search
     * @return true if the element is found in this binary tree, false otherwise
     * @throws NullPointerException if the specified target is null and
     *         this list does not allow null elements
     */
    boolean find(T target);

    /**
     * Returns an iterator over the elements in this binary tree 
     * by performing a pre-order traversal.
     * 
     * @return an iterator over the elements in this binary tree
     */
    Iterator<T> iteratorPreOrder();

    /**
     * Returns an iterator over the elements in this binary tree 
     * by performing an in-order traversal.
     * 
     * @return an iterator over the elements in this binary tree
     */
    Iterator<T> iteratorInOrder();

    /**
     * Returns an iterator over the elements in this binary tree 
     * by performing a post-order traversal.
     * 
     * @return an iterator over the elements in this binary tree
     */
    Iterator<T> iteratorPostOrder();

    /**
     * Returns an iterator over the elements in this binary tree 
     * by performing a level-order traversal.
     * 
     * @return an iterator over the elements in this binary tree
     */
    Iterator<T> iteratorLevelOrder();
}
