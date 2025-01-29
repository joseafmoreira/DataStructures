package pt.ipp.estg.ed.abstractdatatype;

import java.util.Iterator;

/**
 * An iterable collection is a collection that can be looped through using an
 * {@code Iterator} object.
 * <p>
 * 
 * The common operations for an iterable collection include:
 * <p>
 * <ul>
 * <li>{@link #contains(Object)}: Returns true if this collection contains the
 * specified target</li>
 * <li>{@link #toArray()}: Returns an array containing all of the elements in
 * this collection</li>
 * <li>{@link #iterator()}: Returns an iterator over the elements in this
 * collection</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>IterableCollectionADT</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 * @see CollectionADT
 * @see Iterable
 * @see Iterator
 */
public interface IterableCollectionADT<T> extends CollectionADT<T>, Iterable<T> {
    /**
     * Returns true if this collection contains the specified target.
     * 
     * @param target the specified target
     * @return true if this collection contains the specified target, false
     *         otherwise
     * @throws NullPointerException if the specified target is null and
     *                              this list does not allow null elements
     */
    boolean contains(T target);

    /**
     * Returns an array containing all of the elements in this collection.
     * 
     * @return an array containing all of the elements in this collection
     */
    @SuppressWarnings("unchecked")
    default T[] toArray() {
        T[] array = (T[]) new Object[size()];
        int i = 0;
        for (T element : this)
            array[i++] = element;
        return array;
    }

    /**
     * Returns an iterator over the elements in this collection.
     * 
     * @return an iterator over the elements in this collection
     */
    @Override
    Iterator<T> iterator();
}
