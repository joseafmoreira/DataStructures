package dev.joseafmoreira.collection.tree.priorityqueue;

import java.util.Iterator;

import dev.joseafmoreira.collection.AbstractIterableCollection;
import dev.joseafmoreira.collection.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.collection.tree.heap.LinkedMaxHeap;
import dev.joseafmoreira.node.PriorityQueueNode;
import pt.ipp.estg.ed.abstractdatatype.MaxHeapADT;
import pt.ipp.estg.ed.abstractdatatype.PriorityQueueADT;
import pt.ipp.estg.ed.abstractdatatype.UnorderedListADT;
import pt.ipp.estg.ed.exception.EmptyCollectionException;

/**
 * Linked max-heap implementation of the {@code PriorityQueueADT} interface.
 * <p>
 * 
 * <h3>LinkedMaxPriorityQueue</h3>
 * 
 * @param <T> the type of element stored in this priority queue
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractIterableCollection
 * @see PriorityQueueADT
 * @see LinkedMaxHeap
 * @see PriorityQueueNode
 */
public class LinkedMaxPriorityQueue<T> extends AbstractIterableCollection<T> implements PriorityQueueADT<T> {
    /**
     * This priority queue's min-heap.
     */
    protected MaxHeapADT<PriorityQueueNode<T>> maxHeap;

    /**
     * Construct an empty LinkedMaxPriorityQueue object.
     */
    public LinkedMaxPriorityQueue() {
        super();
        maxHeap = new LinkedMaxHeap<>();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public void add(T element, int priority) {
        maxHeap.add(new PriorityQueueNode<>(element, priority));
        size++;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T peek() {
        return maxHeap.findMax().getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException {@inheritDoc}
     */
    @Override
    public T remove() {
        T result = maxHeap.removeMax().getElement();
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
        return maxHeap.contains(new PriorityQueueNode<>(target));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        UnorderedListADT<T> list = new UnorderedArrayList<>(size());
        Iterator<PriorityQueueNode<T>> it = maxHeap.iterator();
        while (it.hasNext())
            list.addLast(it.next().getElement());
        return list.iterator();
    }
}
