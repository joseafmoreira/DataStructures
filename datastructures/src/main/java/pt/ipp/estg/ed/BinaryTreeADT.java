package pt.ipp.estg.ed;

import java.util.Iterator;

/**
 * A binary tree is a non-linear abstract data type that, based of the concept of a tree, 
 * every node, with the exception of the root node, has exactly one parent and, at max, 
 * two children.<p>
 * For this interface, it's only specified the common operations between all binary trees leaving the 
 * unique methods for the ordered and the unordered lists in the 
 * {@code OrderedListADT} and {@code UnorderedListADT} respectively
 * 
 * The common operations for a binary tree include: <p>
 * <ul>
 *  <li>{@link #getRoot()}: Returns the element from the root of this binary tree</li>
 *  <li>{@link #find(Object)}: </li>
 *  <li>{@link #contains(Object)}: </li>
 *  <li>{@link #isEmpty()}: </li>
 *  <li>{@link #size()}: </li>
 *  <li>{@link #iteratorPreOrder()}: </li>
 *  <li>{@link #iteratorInOrder()}: </li>
 *  <li>{@link #iteratorPostOrder()}: </li>
 *  <li>{@link #iteratorLevelOrder()}: </li>
 *  <li>{@link #toString()}: Returns a string representation of this binary tree</li>
 * </ul>
 * 
 * This interface is a member of the 
 * <i>Data Structures Framework</i>
 * 
 * <h3>BinaryTreeADT</h3>
 * @param <T> the type of elements in this binary tree
 * @since 1.0
 * @version 2.0
 * @author ESTG-ED
 */
public interface BinaryTreeADT<T> {
    /**
     * Returns the element from the root of this binary tree.
     * 
     * @return the element from the root of this binary tree
     */
    T getRoot();
    T find(T target);
    boolean contains(T target);
    boolean isEmpty();
    int size();
    Iterator<T> iteratorPreOrder();
    Iterator<T> iteratorInOrder();
    Iterator<T> iteratorPostOrder();
    Iterator<T> iteratorLevelOrder();

    /**
     * Returns a string representation of this binary tree.
     * 
     * @return a string representation of this binary tree
     */
    @Override
    String toString();
}
