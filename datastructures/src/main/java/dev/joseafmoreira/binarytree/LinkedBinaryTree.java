package dev.joseafmoreira.binarytree;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.BinaryTreeADT;
import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.adts.QueueADT;
import dev.joseafmoreira.adts.UnorderedListADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.list.unordered.UnorderedDoubleLinkedList;
import dev.joseafmoreira.queue.LinkedQueue;

/**
 * <h2>
 * LinkedBinaryTree
 * </h2>
 * <p>
 * The {@code LinkedBinaryTree} abstract class that implements the {@link ListADT BinaryTreeADT} interface.
 * </p>
 * <p>
 * The {@code LinkedBinaryTree} is implemented using binary tree {@link BinaryTreeNode nodes}
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public abstract class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    /**
     * This represents the root node of this binary tree
     */
    protected BinaryTreeNode<T> root;
    /**
     * This represents the number of elements in this binary tree
     */
    protected int size;

    /**
     * Instantiate an empty LinkedBinaryTree object
     */
    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Binary Tree is empty");

        return root.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T find(T target) throws NullPointerException, NoSuchElementException {
        if (target == null) throw new NullPointerException("Target is null");

        if (findAgain(root, target) != null) return target;

        throw new NoSuchElementException("Target not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedDoubleLinkedList<>();
        if (!isEmpty()) preOrderTraversal(root, unorderedList);

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedDoubleLinkedList<>();
        if (!isEmpty()) inOrderTraversal(root, unorderedList);

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedDoubleLinkedList<>();
        if (!isEmpty()) postOrderTraversal(root, unorderedList);

        return unorderedList.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        UnorderedListADT<T> unorderedList = new UnorderedDoubleLinkedList<>();
        if (!isEmpty()) {
            QueueADT<BinaryTreeNode<T>> queue = new LinkedQueue<>();
            BinaryTreeNode<T> currentNode;
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                currentNode = queue.dequeue();
                unorderedList.addToRear(currentNode.getElement());
                if (currentNode.getLeft() != null) queue.enqueue(currentNode.getLeft());
                if (currentNode.getRight() != null) queue.enqueue(currentNode.getRight());
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
        inOrderTraversal(root, unorderedList);

        return unorderedList.toString();
    }

    /**
     * Recursively finds a node with the specified target element in the binary tree rooted at the given node.
     *
     * @param currentNode the current node being checked
     * @param target the target element to search for
     * @return the node containing the target element, or null if not found
     */
    private BinaryTreeNode<T> findAgain(BinaryTreeNode<T> currentNode, T target) {
        if (currentNode == null || currentNode.getElement().equals(target)) return currentNode;

        BinaryTreeNode<T> tempNode = findAgain(currentNode.getLeft(), target);
        if (tempNode == null) findAgain(currentNode.getLeft(), target);

        return tempNode;
    }

    /**
     * Performs a pre-order traversal of the binary tree starting from the given node.
     * Adds each element visited to the given unordered list.
     *
     * @param currentNode the current node being visited
     * @param unorderedList the unordered list to add the elements to
     */
    private void preOrderTraversal(BinaryTreeNode<T> currentNode, UnorderedListADT<T> unorderedList) {
        if (currentNode != null) {
            unorderedList.addToRear(currentNode.getElement());
            preOrderTraversal(currentNode.getLeft(), unorderedList);
            preOrderTraversal(currentNode.getRight(), unorderedList);
        }
    }

    /**
     * Performs an in-order traversal of the binary tree starting from the given node.
     * Adds each element visited to the given unordered list.
     *
     * @param currentNode the current node being visited
     * @param unorderedList the unordered list to add the elements to
     */
    private void inOrderTraversal(BinaryTreeNode<T> currentNode, UnorderedListADT<T> unorderedList) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.getLeft(), unorderedList);
            unorderedList.addToRear(currentNode.getElement());
            inOrderTraversal(currentNode.getRight(), unorderedList);
        }
    }

    /**
     * Performs a post-order traversal of the binary tree starting from the given node.
     * Adds each element visited to the given unordered list.
     *
     * @param currentNode the current node being visited
     * @param unorderedList the unordered list to add the elements to
     */
    private void postOrderTraversal(BinaryTreeNode<T> currentNode, UnorderedListADT<T> unorderedList) {
        if (currentNode != null) {
            postOrderTraversal(currentNode.getLeft(), unorderedList);
            postOrderTraversal(currentNode.getRight(), unorderedList);
            unorderedList.addToRear(currentNode.getElement());
        }
    }

    /**
     * <h2>
     * LinkedBinaryTree
     * </h2>
     * <p>
     * The {@code BinaryTreeNode} protected static inner class that specified the behavior of a binary tree node.
     * </p>
     * <p>
     * Author: joseafmoreira
     * </p>
     */
    protected static class BinaryTreeNode<T> {
        /**
         * The element stored in this binary tree node
         */
        protected T element;
        /**
         * The pointer to the left child of this binary tree node
         */
        protected BinaryTreeNode<T> left;
        /**
         * The pointer to the right child of this binary tree node
         */
        protected BinaryTreeNode<T> right;

        /**
         * Instantiate an empty BinaryTreeNode object
         */
        public BinaryTreeNode() {
            this(null, null, null);
        }

        /**
         * Instantiate a new binary tree node object with the specified element
         * 
         * @param element the specified element
         */
        public BinaryTreeNode(T element) {
            this(element, null, null);
        }

        /**
         * Instantiate a new binary tree node object with the specified element, left and right child binary tree node reference
         * 
         * @param element the specified element
         * @param left the left child
         * @param right the right child
         */
        private BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            setElement(element);
            setLeft(left);
            setRight(right);
        }

        /**
         * Returns the element stored in this binary tree node.
         *
         * @return the element stored in this binary tree node
         */
        public T getElement() {
            return element;
        }

        /**
         * Sets the element of this binary tree node.
         * 
         * @param element the new element to be set
         */
        public void setElement(T element) {
            this.element = element;
        }

        /**
         * Returns the left child of this binary tree node.
         *
         * @return the left child of this binary tree node
         */
        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        /**
         * Sets the left child of this binary tree node.
         *
         * @param left the new left child of this binary tree node
         */
        public void setLeft(BinaryTreeNode<T> left) {
            this.left = left;
        }

        /**
         * Returns the right child of this binary tree node.
         *
         * @return the right child of this binary tree node
         */
        public BinaryTreeNode<T> getRight() {
            return right;
        }

        /**
         * Sets the right child of this binary tree node.
         *
         * @param right the new right child of this binary tree node
         */
        public void setRight(BinaryTreeNode<T> right) {
            this.right = right;
        }

        /**
         * Returns a string representation of this binary tree node
         * 
         * @return a string representation of this binary tree node
         */
        @Override
        public String toString() {
            return (element == null) ? "" : element.toString();
        }
    }
}
