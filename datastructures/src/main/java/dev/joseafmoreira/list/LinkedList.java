package dev.joseafmoreira.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.node.Node;

/**
 * <h2>
 * LinkedList
 * </h2>
 * <p>
 * The {@code LinkedList} abstract class that implements the {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code LinkedList} is implemented using single linked {@link Node nodes}
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public abstract class LinkedList<T> implements ListADT<T> {
    /**
     * This represents the head node of this list
     */
    protected Node<T> head;
    /**
     * This represents the tail node of this list
     */
    protected Node<T> tail;
    /**
     * This represents the number of elements in this list
     */
    protected int size;
    /**
     * This represents the number of modifications made in this list
     */
    protected int modCount;

    /**
     * Instantiate an empty LinkedList object
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
        modCount = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        return remove(first());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        return remove(last());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(T target) throws NullPointerException, EmptyCollectionException, NoSuchElementException {
        if (target == null) throw new NullPointerException("Target is null");
        if (isEmpty()) throw new EmptyCollectionException("List is empty");

        Node<T> previousNode = null;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(target)) {
                if (currentNode == head) {
                    head = head.getNext();
                    if (head == null) tail = null;
                } else {
                    previousNode.setNext(currentNode.getNext());
                    if (currentNode == tail) tail = previousNode;
                }
                size--;
                modCount++;

                return target;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        throw new NoSuchElementException("Target not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List is empty");

        return head.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("List is empty");

        return tail.getElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(target)) return true;

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
        if (!isEmpty()) {
            Node<T> currentNode = head;
            while (currentNode != null) {
                result.append(currentNode.getElement());
                if (currentNode.getNext() != null) result.append(", ");
                currentNode = currentNode.getNext();
            }
        }
        result.append("]");

        return result.toString();
    }

    /**
     * <h2>
     * LinkedListIterator
     * </h2>
     * <p>
     * The {@code LinkedListIterator} class that implements the {@link Iterator Iterator} interface.
     * </p>
     * <p>
     * Author: joseafmoreira
     * </p>
     */
    private class LinkedListIterator implements Iterator<T> {
        /**
         * This represents the previous node of the current node of this LinkedListIterator
         */
        private Node<T> previousNode;
        /**
         * This represents the current node of this LinkedListIterator
         */
        private Node<T> currentNode;
        /**
         * This represents the expected number of modifications made in this list
         */
        private int expectedModCount;
        /**
         * This represents if the iterator can remove an element from the list or not
         */
        private boolean okToRemove;

        /**
         * Instantiate a new LinkedListIterator object
         */
        private LinkedListIterator() {
            previousNode = null;
            currentNode = head;
            expectedModCount = modCount;
            okToRemove = false;
        }

        /**
         * {@inheritDoc}
         * @throws ConcurrentModificationException if this list has been modified
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (expectedModCount != modCount) throw new ConcurrentModificationException("List has been modified");

            return currentNode != null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException("Iteration out of elements");

            T result = currentNode.getElement();
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            okToRemove = true;

            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() throws IllegalStateException {
            if (!okToRemove) throw new IllegalStateException("Invalid remove operation call");

            LinkedList.this.remove(previousNode.getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }
}
