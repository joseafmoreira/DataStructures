package dev.joseafmoreira.binarytree;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.BinaryTreeADT;
import dev.joseafmoreira.adts.QueueADT;
import dev.joseafmoreira.adts.UnorderedListADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.list.unordered.UnorderedDoubleLinkedList;
import dev.joseafmoreira.list.unordered.UnorderedLinkedList;
import dev.joseafmoreira.queue.CircularArrayQueue;

/**
 * <h2>
 * ArrayBinaryTree
 * </h2>
 * <p>
 * The {@code ArrayBinaryTree} abstract class that implements the {@link BinaryTreeADT BinaryTreeADT} interface.
 * </p>
 * <p>
 * The {@code ArrayBinaryTree} is implemented using an array
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public abstract class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    /**
     * This represents the default capacity of this binary tree
     */
    protected static final int DEFAULT_CAPACITY = 7;
    /**
     * This represents the arrays containing the elements of this binary tree
     */
    protected T[] array;
    /**
     * This represents the number of elements in this binary tree
     */
    protected int size;

    /**
     * Instantiate an empty ArrayBinaryTree object
     */
    public ArrayBinaryTree() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Instantiate an empty ArrayBinaryTree with a specified initial capacity
     * 
     * @param initialCapacity the specified initial capacity of the array (Minimum value is 0)
     */
    @SuppressWarnings("unchecked")
    public ArrayBinaryTree(int initialCapacity) {
        array = (T[]) new Object[Math.max(initialCapacity, 0)];
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Binary Tree is empty");

        return array[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T find(T target) throws NullPointerException, NoSuchElementException {
        if (target == null) throw new NullPointerException("Target is null");

        for (int i = 0; i < array.length; i++) if ( array[i] != null && array[i].equals(target)) return target;

        throw new NoSuchElementException("Target not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedLinkedList<>();
        preOrderTraversal(0, unorderedList);

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedLinkedList<>();
        inOrderTraversal(0, unorderedList);

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedLinkedList<>();
        postOrderTraversal(0, unorderedList);

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedDoubleLinkedList<>();
        if (!isEmpty()) {
            QueueADT<Integer> queue = new CircularArrayQueue<>(size());
            Integer currentIndex;
            queue.enqueue(0);
            while (!queue.isEmpty()) {
                currentIndex = queue.dequeue();
                unorderedList.addToRear(array[currentIndex]);
                if (currentIndex < array.length && array[2 * currentIndex + 1] != null) queue.enqueue(2 * currentIndex + 1);
                if (currentIndex < array.length && array[2 * (currentIndex + 1)] != null) queue.enqueue(2 * (currentIndex + 1));
            }
        }

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T target) throws NullPointerException {
        try {
            find(target);
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        UnorderedListADT<T> unorderedList = new UnorderedArrayList<>();
        inOrderTraversal(0, unorderedList);

        return unorderedList.toString();
    }

    /**
     * Expands the capacity of the array used by the list.
     * If the current array length is less than 2, the new array length will be increased by 1.
     * Otherwise, the new array length will be increased by half of the current array length.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        T[] newArray = (T[]) new Object[2 * array.length + 1];
        for (int i = 0; i < array.length; i++) newArray[i] = array[i];

        array = newArray;
    }

    /**
     * Performs a pre-order traversal of the binary tree starting from the specified index.
     * Adds each element encountered during the traversal to the given unordered list.
     *
     * @param currentIndex the index of the current node in the binary tree
     * @param unorderedList the unordered list to add the elements to
     */
    private void preOrderTraversal(int currentIndex, UnorderedListADT<T> unorderedList) {
        if (currentIndex < array.length && array[currentIndex] != null) {
            unorderedList.addToRear(array[currentIndex]);
            preOrderTraversal(2 * currentIndex + 1, unorderedList);
            preOrderTraversal(2 * (currentIndex + 1), unorderedList);
        }
    }

    /**
     * Performs an in-order traversal of the binary tree starting from the specified index.
     * Adds each element encountered during the traversal to the given unordered list.
     *
     * @param currentIndex the index of the current node in the binary tree
     * @param unorderedList the unordered list to add the elements to
     */
    private void inOrderTraversal(int currentIndex, UnorderedListADT<T> unorderedList) {
        if (currentIndex < array.length && array[currentIndex] != null) {
            inOrderTraversal(2 * currentIndex + 1, unorderedList);
            unorderedList.addToRear(array[currentIndex]);
            inOrderTraversal(2 * (currentIndex + 1), unorderedList);
        }
    }

    /**
     * Performs a post-order traversal of the binary tree starting from the specified index.
     * Adds each element encountered during the traversal to the given unordered list.
     *
     * @param currentIndex the index of the current node in the binary tree
     * @param unorderedList the unordered list to add the elements to
     */
    private void postOrderTraversal(int currentIndex, UnorderedListADT<T> unorderedList) {
        if (currentIndex < array.length && array[currentIndex] != null) {
            postOrderTraversal(2 * currentIndex + 1, unorderedList);
            postOrderTraversal(2 * (currentIndex + 1), unorderedList);
            unorderedList.addToRear(array[currentIndex]);
        }
    }
}
