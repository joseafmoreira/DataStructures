package dev.joseafmoreira.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dev.joseafmoreira.adts.ListADT;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.node.DoubleNode;

/**
 * <h2>
 * DoubleLinkedList
 * </h2>
 * <p>
 * The {@code DoubleLinkedList} abstract class that implements the {@link ListADT ListADT} interface.
 * </p>
 * <p>
 * The {@code DoubleLinkedList} is implemented using double linked {@link DoubleNode nodes}
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public abstract class DoubleLinkedList<T> implements ListADT<T> {
    /**
     * This represents the head node of this list
     */
    protected DoubleNode<T> head;
    /**
     * This represents the tail node of this list
     */
    protected DoubleNode<T> tail;
    /**
     * This represents the number of elements in this list
     */
    protected int size;
    /**
     * This represents the number of modifications made in this list
     */
    private int modCount;

    /**
     * Instantiate an empty DoubleLinkedList object
     */
    public DoubleLinkedList() {
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

        DoubleNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(target)) {
                if (currentNode == head) {
                    head = currentNode.getNext();
                    if (size() == 1) tail = head;
                    else head.setPrev(null);
                } else {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    if (currentNode == tail) tail = currentNode.getPrev();
                    else currentNode.getNext().setPrev(currentNode.getPrev());
                }
                size--;
                modCount++;

                return target;
            }
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
        DoubleNode<T> currentNode = head;
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
        return new DoubleLinkedListIterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (!isEmpty()) {
            DoubleNode<T> currentNode = head;
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
     * DoubleLinkedListIterator
     * </h2>
     * <p>
     * The {@code DoubleLinkedListIterator} class that implements the {@link Iterator Iterator} interface.
     * </p>
     * <p>
     * Author: joseafmoreira
     * </p>
     */
    private class DoubleLinkedListIterator implements Iterator<T> {
        /**
         * This represents the current node of this DoubleLinkedListIterator
         */
        private DoubleNode<T> currentNode;
        /**
         * This represents the expected number of modifications made in this list
         */
        private int expectedModCount;
        /**
         * This represents if the iterator can remove an element from the list or not
         */
        private boolean okToRemove;

        /**
         * Instantiate a new DoubleLinkedListIterator object
         */
        private DoubleLinkedListIterator() {
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

            DoubleLinkedList.this.remove((currentNode == null) ? tail.getElement() : currentNode.getPrev().getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }
}
