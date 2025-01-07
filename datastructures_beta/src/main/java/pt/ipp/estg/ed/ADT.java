package pt.ipp.estg.ed;

/**
 * An abstract data type is an abstract mathematical model of data structures or 
 * data types with common operations and behaviours without a specification of how 
 * these operations are implemented. <p>
 * 
 * The common operations for an abstract data type include: <p>
 * <ul>
 *  <li>{@link #isEmpty()}: Checks if this abstract data type is empty</li>
 *  <li>{@link #size()}: Returns the number of elements present in this abstract data type</li>
 *  <li>{@link #toString()}: Returns a string representation of this abstract data type</li>
 * </ul>
 * 
 * This interface is a member of the 
 * <i>Data Structures Framework</i>
 * 
 * <h3>ADT</h3>
 * @param <T> the type of elements in this abstract data type
 * @since 1.0
 * @version 1.0
 * @author ESTG-ED
 */
public interface ADT<T> {
    /**
     * Checks if this abstract data type is empty.
     * 
     * @return true if this abstract data type is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements present in this abstract data type.
     * 
     * @return the number of elements present in this abstract data type
     */
    int size();

    /**
     * Returns a string representation of this abstract data type.
     * 
     * @return a string representation of this abstract data type
     */
    @Override
    String toString();
}
