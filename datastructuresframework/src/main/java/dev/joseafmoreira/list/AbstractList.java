package dev.joseafmoreira.list;

import dev.joseafmoreira.collection.AbstractIterableCollection;
import pt.ipp.estg.ed.abstractdatatype.ListADT;

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
