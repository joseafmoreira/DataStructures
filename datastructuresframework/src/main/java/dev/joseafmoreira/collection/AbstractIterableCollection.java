package dev.joseafmoreira.collection;

import java.util.Iterator;
import java.util.StringJoiner;

import pt.ipp.estg.ed.abstractdatatype.IterableCollectionADT;

/**
 * This class provides a skeletal implementation of the
 * {@code IterableCollectionADT} interface, to minimize the effort
 * required to implement this interface.
 * <p>
 * 
 * <h3>AbstractIterableCollection</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see AbstractCollection
 * @see IterableCollectionADT
 */
public abstract class AbstractIterableCollection<T> extends AbstractCollection<T> implements IterableCollectionADT<T> {
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

        AbstractIterableCollection<T> collection = (AbstractIterableCollection<T>) obj;
        if (size() != collection.size())
            return false;
        Iterator<T> it1 = iterator();
        Iterator<T> it2 = collection.iterator();
        while (it1.hasNext())
            if (!(it1.next().equals(it2.next())))
                return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        for (T element : this)
            hashCode = PRIME_NUMBER * hashCode + (element == null ? 0 : element.hashCode());
        return hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (T element : this)
            result.add(element.toString());
        return result.toString();
    }
}
