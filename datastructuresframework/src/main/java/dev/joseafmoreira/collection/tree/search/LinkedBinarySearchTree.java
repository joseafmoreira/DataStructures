package dev.joseafmoreira.collection.tree.search;

import java.util.NoSuchElementException;

import dev.joseafmoreira.collection.tree.LinkedBinaryTree;
import dev.joseafmoreira.node.BinaryTreeNode;
import pt.ipp.estg.ed.abstractdatatype.BinarySearchTreeADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Linked implementation of the {@code BinarySearchTreeADT} interface
 * using the {@code LinkedBinaryTree} class as a base code.
 * 
 * <h3>LinkedBinarySearchTree</h3>
 * 
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedBinaryTree
 * @see BinarySearchTreeADT
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * Constructs an empty LinkedBinarySearchTree object.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void add(T element) {
        if (element == null)
            throw new NullPointerException("Element is null");
        Comparable<T> comparableElement = (Comparable<T>) element;
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(element);
        if (isEmpty())
            root = newNode;
        else {
            BinaryTreeNode<T> currentNode = root;
            while (true) {
                if (comparableElement.compareTo(currentNode.getElement()) <= 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    } else
                        currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    } else
                        currentNode = currentNode.getRight();
                }
            }
        }
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    public T findMin() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        BinaryTreeNode<T> currentNode = root;
        while (currentNode.getLeft() != null)
            currentNode = currentNode.getLeft();
        return currentNode.getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    public T findMax() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        BinaryTreeNode<T> currentNode = root;
        while (currentNode.getRight() != null)
            currentNode = currentNode.getRight();
        return currentNode.getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException     {@inheritDoc}
     * @throws EmptyCollectionException {@inheritDoc}
     * @throws NoSuchElementException   {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T remove(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        Comparable<T> comparableTarget = (Comparable<T>) target;
        boolean hasRemoved = false;
        if (comparableTarget.equals(root.getElement())) {
            root = replacement(root);
            size--;
            hasRemoved = true;
        } else {
            BinaryTreeNode<T> parentNode = root;
            BinaryTreeNode<T> currentNode = (comparableTarget.compareTo(parentNode.getElement()) <= 0)
                    ? parentNode.getLeft()
                    : parentNode.getRight();
            while (currentNode != null) {
                if (comparableTarget.equals(currentNode.getElement())) {
                    if (currentNode == parentNode.getLeft())
                        parentNode.setLeft(replacement(currentNode));
                    else
                        parentNode.setRight(replacement(currentNode));
                    size--;
                    hasRemoved = true;
                    break;
                } else {
                    parentNode = currentNode;
                    currentNode = (comparableTarget.compareTo(parentNode.getElement()) <= 0) ? parentNode.getLeft()
                            : parentNode.getRight();
                }
            }
        }
        if (hasRemoved)
            return target;
        throw new NoSuchElementException("Target not found");
    }

    /**
     * Returns the replacement node for the given node in this binary search tree.
     * The replacement node is determined based on the following rules:
     * - If the given node has no left child and no right child, the replacement
     * node is null.
     * - If the given node has a left child but no right child, the replacement node
     * is the left child.
     * - If the given node has no left child but a right child, the replacement node
     * is the right child.
     * - If the given node has both left and right children, the replacement node is
     * the leftmost node in the right subtree.
     * If the leftmost node in the right subtree is the right child of the given
     * node, the replacement node is set to have the left child of the given node.
     * Otherwise, the replacement node is set to have the right child of its parent,
     * the right child of the given node, and the left child of the given node.
     *
     * @param node the node for which to find the replacement node
     * @return the replacement node for the given node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result;
        if (node.getLeft() == null && node.getRight() == null)
            result = null;
        else if (node.getLeft() != null && node.getRight() == null)
            result = node.getLeft();
        else if (node.getLeft() == null && node.getRight() != null)
            result = node.getRight();
        else {
            BinaryTreeNode<T> currentNode = node.getRight();
            BinaryTreeNode<T> parentNode = node;
            while (currentNode.getLeft() != null) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            }
            if (node.getRight() == currentNode)
                currentNode.setLeft(node.getLeft());
            else {
                parentNode.setLeft(currentNode.getRight());
                currentNode.setRight(node.getRight());
                currentNode.setLeft(node.getLeft());
            }
            result = currentNode;
        }
        return result;
    }
}
