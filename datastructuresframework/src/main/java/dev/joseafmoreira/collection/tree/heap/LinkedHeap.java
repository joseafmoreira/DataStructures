package dev.joseafmoreira.collection.tree.heap;

import dev.joseafmoreira.collection.tree.LinkedBinaryTree;
import dev.joseafmoreira.node.HeapNode;

/**
 * This class provides a skeletal implemetation for a linked-based heap
 * having all the common method implementations.
 * <p>
 * 
 * <h3>LinkedHeap</h3>
 * 
 * @param <T> the type of elements in this heap
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see LinkedBinaryTree
 */
public abstract class LinkedHeap<T> extends LinkedBinaryTree<T> {
    /**
     * The reference to the last node added in this heap.
     */
    protected HeapNode<T> lastNode;

    /**
     * Constructor for use by subclasses.
     */
    protected LinkedHeap() {
        super();
        lastNode = null;
    }
}
