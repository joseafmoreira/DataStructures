package dev.joseafmoreira.collection.list;

import dev.joseafmoreira.collection.AbstractIterableCollection;
import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * This class provides a skeletal implemetation for a list
 * having all the common method implementations.
 * <p>
 * 
 * <h3>AbstractLinkedListCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractIterableCollection
 * @see ListADT
 */
public abstract class AbstractList<T> extends AbstractIterableCollection<T> implements ListADT<T> {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T target) {
        if (target == null)
            throw new NullPointerException("Target is null");
        for (T element : this)
            if (element.equals(target))
                return true;
        return false;
    }
}
