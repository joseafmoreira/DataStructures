package dev.joseafmoreira.binarytree.search;

import dev.joseafmoreira.adts.BinaryTreeADT;

import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.BinarySearchTreeADT;
import dev.joseafmoreira.binarytree.ArrayBinaryTree;
import dev.joseafmoreira.exceptions.EmptyCollectionException;

/**
 * <h2>
 * ArrayBinarySearchTree
 * </h2>
 * <p>
 * The {@code ArrayBinarySearchTree} class that implements both the {@link BinarySearchTreeADT BinarySearchTreeADT} and {@link BinaryTreeADT BinaryTreeADT} interface.
 * </p>
 * <p>
 * The {@code ArrayBinarySearchTree} is implemented using the {@link ArrayBinaryTree LinkedBinaryTree} abstract class as the base {@link BinaryTreeADT BinaryTreeADT} implementation
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * This represents the index of the most distant element in this binary search tree
     */
    protected int maxIndex;

    /**
     * Instantiate an empty ArrayBinarySearchTree object
     */
    public ArrayBinarySearchTree() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Instantiate an empty ArrayBinarySearchTree with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayBinarySearchTree(int initialCapacity) {
        super(initialCapacity);
        maxIndex = 0;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addElement(T element) throws NullPointerException, ClassCastException {
        if (element == null) throw new NullPointerException("Element is null");
        if (2 * (maxIndex + 1) >= array.length) expandCapacity();

        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty()) {
            array[0] = element;
            maxIndex = 0;
        } else {
            int currentIndex = 0;
            while (true) {
                if (comparableElement.compareTo(array[currentIndex]) < 0) {
                    if (array[2 * currentIndex + 1] == null) {
                        array[2 * currentIndex + 1] = element;
                        if (2 * currentIndex + 1 > maxIndex) maxIndex = 2 * currentIndex + 1;
                        break;
                    } else {
                        currentIndex = 2 * currentIndex + 1;
                    }
                } else {
                    if (array[2 * (currentIndex + 1)] == null) {
                        array[2 * (currentIndex + 1)] = element;
                        if (2 * (currentIndex + 1) > maxIndex) maxIndex = 2 * (currentIndex + 1);
                        break;
                    } else {
                        currentIndex = 2 * (currentIndex + 1);
                    }
                }
            }
        }
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public T removeElement(T target) throws NullPointerException, EmptyCollectionException, ClassCastException, NoSuchElementException {
        if (target == null) throw new NullPointerException("Target is null");
        if (isEmpty()) throw new EmptyCollectionException("Binary Search Tree is empty");

        Comparable<T> comparableTarget = (Comparable<T>) target;
        int currentIndex = 0;
        while (true) {
            if (comparableTarget.compareTo(array[currentIndex]) < 0) {
                
            }
        }

        throw new NoSuchElementException("Target not found");
    }
}
