package dev.joseafmoreira.collection.tree;

import java.util.Iterator;

import dev.joseafmoreira.collection.AbstractIterableCollection;
import dev.joseafmoreira.collection.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.collection.queue.LinkedQueue;
import dev.joseafmoreira.node.BinaryTreeNode;
import pt.ipp.estg.ed.abstractdatatype.BinaryTreeADT;
import pt.ipp.estg.ed.abstractdatatype.QueueADT;
import pt.ipp.estg.ed.abstractdatatype.UnorderedListADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Linked implementation of the {@code BinaryTreeADT} interface.
 * 
 * <h3>LinkedBinaryTree</h3>
 * @param <T> the type of element stored in this binary tree
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractIterableCollection
 * @see BinaryTreeADT
 */
public class LinkedBinaryTree<T> extends AbstractIterableCollection<T> implements BinaryTreeADT<T> {
    /**
     * The root node of this binary tree
     */
    protected BinaryTreeNode<T> root;

    /**
     * Constructor for use by subclasses.
     */
    protected LinkedBinaryTree() {
        super();
        root = null;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T getRoot() {
        if (isEmpty())
            throw new EmptyCollectionException("Binary tree is empty");
        return root.getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException   if the elements in this binary tree aren't
     *                              comparable
     * 
     */
    @Override
    public boolean contains(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        if (find(root, target) != null)
            return true;
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> list = new UnorderedArrayList<>();
        preOrder(root, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> list = new UnorderedArrayList<>();
        inOrder(root, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> list = new UnorderedArrayList<>();
        postOrder(root, list);
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        UnorderedListADT<T> list = new UnorderedArrayList<>();
        QueueADT<BinaryTreeNode<T>> queue = new LinkedQueue<>();
        if (root != null)
            queue.enqueue(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> currentNode = queue.dequeue();
            list.addLast(currentNode.getElement());
            if (currentNode.getLeft() != null)
                queue.enqueue(currentNode.getLeft());
            if (currentNode.getRight() != null)
                queue.enqueue(currentNode.getRight());
        }
        return list.iterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        root = null;
    }

    /**
     * Recursively searches for a target element in this binary tree starting from
     * the given node.
     * 
     * @param currentNode the current node being checked
     * @param target      the target to search
     * @return the node containing the target element, or null if not found
     */
    private BinaryTreeNode<T> find(BinaryTreeNode<T> currentNode, T target) {
        if (currentNode == null)
            return null;
        if (currentNode.getElement().equals(target))
            return currentNode;
        BinaryTreeNode<T> tempNode = find(currentNode.getLeft(), target);
        if (tempNode == null)
            tempNode = find(currentNode.getRight(), target);
        return tempNode;
    }

    /**
     * Performs a pre-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param list the list to add the elements to
     */
    private void preOrder(BinaryTreeNode<T> currentNode, UnorderedListADT<T> list) {
        if (currentNode == null) return;
        list.addLast(currentNode.getElement());
        preOrder(currentNode.getLeft(), list);
        preOrder(currentNode.getRight(), list);
    }

    /**
     * Performs an in-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param list the list to add the elements to
     */
    private void inOrder(BinaryTreeNode<T> currentNode, UnorderedListADT<T> list) {
        if (currentNode == null) return;
        inOrder(currentNode.getLeft(), list);
        list.addLast(currentNode.getElement());
        inOrder(currentNode.getRight(), list);
    }

    /**
     * Performs a post-order traversal of this binary tree,
     * adding each element to the list.
     * 
     * @param currentNode the current node being visited
     * @param unorderedList the list to add the elements to
     */
    private void postOrder(BinaryTreeNode<T> currentNode, UnorderedListADT<T> list) {
        if (currentNode == null) return;
        postOrder(currentNode.getLeft(), list);
        postOrder(currentNode.getRight(), list);
        list.addLast(currentNode.getElement());
    }
}
