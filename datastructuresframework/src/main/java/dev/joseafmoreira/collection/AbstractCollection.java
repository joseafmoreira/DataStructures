package dev.joseafmoreira.collection;

import pt.ipp.estg.ed.abstractdatatype.CollectionADT;

/**
 * This class provides a skeletal implementation of the {@code CollectionADT}
 * interface, to minimize the effort required to implement this interface.
 * <p>
 * 
 * <h3>AbstractCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see CollectionADT
 */
public abstract class AbstractCollection<T> implements CollectionADT<T> {
    /**
     * The prime number used to generate the hash for this collection
     */
    protected static final int PRIME_NUMBER = 31;
    /**
     * The number of elements in this collection
     */
    protected int size;

    /**
     * Constructor for use by subclasses.
     */
    protected AbstractCollection() {
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }
}
