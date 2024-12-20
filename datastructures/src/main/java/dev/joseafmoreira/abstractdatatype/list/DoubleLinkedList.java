package dev.joseafmoreira.abstractdatatype.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.exception.EmptyCollectionException;
import dev.joseafmoreira.node.DoubleLinearNode;
import pt.ipp.estg.ed.ListADT;

/**
 * Doubly-linked list implementation of the {@code ListADT} interface.
 * 
 * <h3>DoubleLinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 * @see DoubleLinearNode
 */
public class DoubleLinkedList<T> implements ListADT<T> {
    /**
     * The head node of this list.
     */
    protected DoubleLinearNode<T> head;
    /**
     * The tail node of this list.
     */
    protected DoubleLinearNode<T> tail;
    /**
     * The number of elements in this list
     */
    protected int size;
    /**
     * The number of modifications made to this list
     */
    protected int modCount;

    /**
     * Constructs an empty DoubleLinkedList object.
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
        modCount = 0;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        T result = first();
        head = head.getNext();
        head.getPrev().setNext(null);
        head.setPrev(null);
        size--;
        modCount++;

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        T result = last();
        if (size() == 1)
            removeFirst();
        else {
            tail = tail.getPrev();
            tail.getNext().setPrev(null);
            tail.setNext(null);
            size--;
            modCount++;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException     if the target is null
     * @throws EmptyCollectionException if this list is empty
     * @throws NoSuchElementException   if the target isn't on this list
     */
    @Override
    public T remove(T target) throws NullPointerException, EmptyCollectionException, NoSuchElementException {
        if (target == null)
            throw new NullPointerException("Target is null");

        if (first().equals(target))
            return removeFirst();
        if (last().equals(target))
            return removeLast();
        if (size() > 2) {
            DoubleLinearNode<T> currentNode = head.getNext();
            while (currentNode != tail) {
                if (currentNode.getElement().equals(target)) {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                    currentNode.setNext(null);
                    currentNode.setPrev(null);
                    size--;
                    modCount++;

                    return target;
                }
                currentNode = currentNode.getNext();
            }
        }

        throw new NoSuchElementException("Target not found");
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");

        return head.getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws EmptyCollectionException if this list is empty
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("List is empty");

        return tail.getElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @throws NullPointerException if the target is null
     */
    @Override
    public boolean contains(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");

        DoubleLinearNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(target))
                return true;
            currentNode = currentNode.getNext();
        }
        return false;
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
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        DoubleLinearNode<T> currentNode = head;
        while (currentNode != null) {
            result.append(currentNode.getElement()).append((currentNode != tail) ? ", " : "");
            currentNode = currentNode.getNext();
        }
        result.append("]");

        return result.toString();
    }

    private class DoubleLinkedListIterator implements Iterator<T> {
        /**
         * The current node of this double linked list
         */
        private DoubleLinearNode<T> currentNode;
        /**
         * The expected number of modifications made to this list
         */
        private int expectedModCount;
        /**
         * The flag indicating if it's ok to call the remove method
         */
        private boolean okToRemove;

        /**
         * Constructs an empty DoubleLinkedListIterator object.
         */
        public DoubleLinkedListIterator() {
            currentNode = head;
            expectedModCount = modCount;
            okToRemove = false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public T next() throws ConcurrentModificationException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");

            T result = currentNode.getElement();
            okToRemove = true;
            currentNode = currentNode.getNext();

            return result;
        }

        /**
         * {@inheritDoc}
         * 
         * @throws ConcurrentModificationException if this list has been altered
         */
        @Override
        public void remove() throws ConcurrentModificationException, IllegalStateException {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException("List has been altered");
            if (!okToRemove)
                throw new IllegalStateException("Invalid remove call");

            DoubleLinkedList.this
                    .remove((currentNode == null) ? tail.getElement() : currentNode.getPrev().getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }
}
