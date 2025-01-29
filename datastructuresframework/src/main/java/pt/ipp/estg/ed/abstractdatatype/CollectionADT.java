package pt.ipp.estg.ed.abstractdatatype;

/**
 * A collection is an abstract data type that is a grouping of items that can be
 * used in a
 * polymorphic way.
 * <p>
 * 
 * The common operations for a collection include:
 * <p>
 * <ul>
 * <li>{@link #clear()}: Removes all the elements from this collection</li>
 * <li>{@link #isEmpty()}: Checks if this collection is empty</li>
 * <li>{@link #size()}: Returns the number of elements present in this
 * collection</li>
 * <li>{@link #equals(Object)}: Indicates whether some other object is "equal
 * to" this collection</li>
 * <li>{@link #hashCode()}: Returns a hash code value for this collection</li>
 * <li>{@link #toString()}: Returns a string representation of this
 * collection</li>
 * </ul>
 * 
 * This interface is a member of the
 * <i>Data Structures Framework</i>
 * 
 * <h3>CollectionADT</h3>
 * 
 * @param <T> the type of elements in this collection
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 */
public interface CollectionADT<T> {
    /**
     * Removes all the elements from this collection.
     */
    void clear();

    /**
     * Checks if this collection is empty.
     * 
     * @return true if this collection is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements present in this collection.
     * 
     * @return the number of elements present in this collection
     */
    int size();

    /**
     * Indicates whether some other object is "equal to" this collection.
     * 
     * @param obj the specified object to be compared with this collection
     * @return true if the object is equal to this collection, false otherwise
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns a hash code value for this collection.
     * 
     * @return a hash code value for this collection
     */
    @Override
    int hashCode();

    /**
     * Returns a string representation of this collection.
     * 
     * @return a string representation of this collection
     */
    @Override
    String toString();
}
