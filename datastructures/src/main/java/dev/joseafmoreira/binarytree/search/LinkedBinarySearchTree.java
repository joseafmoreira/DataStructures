package dev.joseafmoreira.binarytree.search;

import dev.joseafmoreira.adts.BinaryTreeADT;
import dev.joseafmoreira.adts.BinarySearchTreeADT;
import dev.joseafmoreira.binarytree.LinkedBinaryTree;
import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * LinkedBinarySearchTree
 * </h2>
 * <p>
 * The {@code LinkedBinarySearchTree} class that implements both the {@link BinarySearchTreeADT BinarySearchTreeADT} and {@link BinaryTreeADT BinaryTreeADT} interface.
 * </p>
 * <p>
 * The {@code LinkedBinarySearchTree} is implemented using the {@link LinkedBinaryTree LinkedBinaryTree} abstract class as the base {@link BinaryTreeADT BinaryTreeADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * Instantiate an empty LinkedBinarySearchTree object
     */
    public LinkedBinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addElement(T element) throws NullPointerException, ClassCastException {
        if (element == null) throw new NullPointerException("Element is null");

        Comparable<T> comparableElement = (Comparable<T>) element;
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(element);
        if (isEmpty()) root = newNode;
        else {
            BinaryTreeNode<T> currentNode = root;
            while (true) {
                if (comparableElement.compareTo(currentNode.getElement()) < 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        break;
                    }
                    else currentNode = currentNode.getLeft();
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        break;
                    }
                    else currentNode = currentNode.getRight();
                }
            }
        }
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeElement(T target) throws NullPointerException, EmptyCollectionException {
        if (target == null) throw new NullPointerException("Target is null");
        if (isEmpty()) throw new EmptyCollectionException("Binary Search Tree is empty"):
    }
}
