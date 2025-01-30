package dev.joseafmoreira.collection.tree.priorityqueue;

import java.util.Iterator;

import dev.joseafmoreira.collection.AbstractIterableCollection;
import dev.joseafmoreira.collection.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.collection.tree.heap.LinkedMinHeap;
import dev.joseafmoreira.node.PriorityQueueNode;
import pt.ipp.estg.ed.abstractdatatype.MinHeapADT;
import pt.ipp.estg.ed.abstractdatatype.PriorityQueueADT;
import pt.ipp.estg.ed.abstractdatatype.UnorderedListADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Linked min-heap implementation of the {@code PriorityQueueADT} interface.
 * <p>
 * 
 * <h3>LinkedMinPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractIterableCollection
 * @see PriorityQueueADT
 * @see LinkedMinHeap
 * @see PriorityQueueNode
 */
public class LinkedMinPriorityQueue<T> extends AbstractIterableCollection<T> implements PriorityQueueADT<T> {
    /**
     * This priority queue's min-heap.
     */
    protected MinHeapADT<PriorityQueueNode<T>> minHeap;

    /**
     * Construct an empty LinkedMinPriorityQueue object.
     */
    public LinkedMinPriorityQueue() {
        super();
        minHeap = new LinkedMinHeap<>();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void add(T element, int priority) {
        minHeap.add(new PriorityQueueNode<>(element, priority));
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T peek() {
        return minHeap.findMin().getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T remove() {
        T result = minHeap.removeMin().getElement();
        size--;
        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
        return minHeap.contains(new PriorityQueueNode<>(target));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        UnorderedListADT<T> list = new UnorderedArrayList<>(minHeap.size());
        Iterator<PriorityQueueNode<T>> it = minHeap.iterator();
        while (it.hasNext())
            list.addLast(it.next().getElement());
        return list.iterator();
    }
}
