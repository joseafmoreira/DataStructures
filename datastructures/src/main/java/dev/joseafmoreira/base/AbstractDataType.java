package dev.joseafmoreira.base;

/**
 * The root interface of the <i>abstract data type hierarchy</i>. An abstract data type 
 * represents a data structure, collection or groups of objects, known as it's <i>elements</i>. <p>
 * 
 * Every abstract data type will have it's unique methods but will also have commons methods 
 * that are represented in this {@link AbstractDataType} interface. <p>
 * 
 * The {@link #isEmpty()} and {@link #size()} methods 
 * are implemented in the {@code AbstractDataTypeImpl} abstract class so that the 
 * programmer only needs to extend this class to have implementations for those methods 
 * making this project structure more centered and organized. <p>
 * 
 * @author joseafmoreira
 * @see AbstractDataTypeImpl
 * @since 2.0
 */
public interface AbstractDataType {
    /**
     * Checks if this abstract data type is empty.
     * 
     * @return true if this abstract data type is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements present in this abstract data type
     * 
     * @return the number of elements in this abstract data type
     */
    int size();

    @Override
    boolean equals(Object obj);

    /**
     * Returns a string representation of this abstract data type.
     * 
     * @return a string representation of this abstract data type
     */
    @Override
    String toString();
}
