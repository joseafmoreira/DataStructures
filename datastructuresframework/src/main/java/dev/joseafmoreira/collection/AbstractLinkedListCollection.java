package dev.joseafmoreira.collection;

import dev.joseafmoreira.node.LinearNode;

/**
 * This class provides a skeletal implemetation for a singly-linked list based
 * collection having all the common method implementations.
 * <p>
 * 
 * <h3>AbstractLinkedListCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractCollection
 * @see LinearNode
 */
public abstract class AbstractLinkedListCollection<T> extends AbstractCollection<T> {
    /**
     * The head node of this collection
     */
    protected LinearNode<T> head;

    /**
     * Constructor for use by subclasses.
     */
    protected AbstractLinkedListCollection() {
        super();
        head = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.clear();
        head = null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        AbstractLinkedListCollection<T> collection = (AbstractLinkedListCollection<T>) obj;
        if (size() != collection.size())
            return false;
        LinearNode<T> currentNode1 = head;
        LinearNode<T> currentNode2 = collection.head;
        while (currentNode1 != null)
            if (!currentNode1.equals(currentNode2))
                return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        LinearNode<T> currentNode = head;
        while (currentNode != null) {
            hashCode = PRIME_NUMBER * hashCode
                    + (currentNode.getElement() == null ? 0 : currentNode.getElement().hashCode());
            currentNode = currentNode.getNext();
        }
        return hashCode;
    }
}
