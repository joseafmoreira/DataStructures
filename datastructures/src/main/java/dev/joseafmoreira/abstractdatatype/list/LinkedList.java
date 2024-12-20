package dev.joseafmoreira.abstractdatatype.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.exception.EmptyCollectionException;
import dev.joseafmoreira.node.LinearNode;
import pt.ipp.estg.ed.ListADT;

/**
 * Singly-linked list implementation of the {@code ListADT} interface.
 * 
 * <h3>LinkedList</h3>
 * 
 * @param <T> the type of element stored in this list
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 * @see LinearNode
 */
public class LinkedList<T> implements ListADT<T> {
    /**
     * The head node of this list.
     */
    protected LinearNode<T> head;
    /**
     * The tail node of this list.
     */
    protected LinearNode<T> tail;
    /**
     * The number of elements in this list
     */
    protected int size;
    /**
     * The number of modifications made to this list
     */
    protected int modCount;

    /**
     * Constructs an empty LinkedList object.
     */
    public LinkedList() {
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
            LinearNode<T> currentNode = head;
            while (currentNode.getNext() != tail)
                currentNode = currentNode.getNext();
            tail = currentNode;
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
            LinearNode<T> previousNode = head;
            LinearNode<T> currentNode = head.getNext();
            while (currentNode != tail) {
                if (currentNode.getElement().equals(target)) {
                    previousNode.setNext(currentNode.getNext());
                    currentNode.setNext(null);
                    size--;
                    modCount++;

                    return target;
                }
                previousNode = currentNode;
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

        LinearNode<T> currentNode = head;
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
        return new LinkedListIterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        LinearNode<T> currentNode = head;
        while (currentNode != null) {
            result.append(currentNode.getElement()).append((currentNode != tail) ? ", " : "");
            currentNode = currentNode.getNext();
        }
        result.append("]");

        return result.toString();
    }

    private class LinkedListIterator implements Iterator<T> {
        /**
         * The previous node of this linked list
         */
        private LinearNode<T> previousNode;
        /**
         * The current node of this linked list
         */
        private LinearNode<T> currentNode;
        /**
         * The expected number of modifications made to this list
         */
        private int expectedModCount;
        /**
         * The flag indicating if it's ok to call the remove method
         */
        private boolean okToRemove;

        /**
         * Constructs an empty LinkedListIterator object.
         */
        public LinkedListIterator() {
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
            previousNode = currentNode;
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

            LinkedList.this.remove(previousNode.getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }
}
