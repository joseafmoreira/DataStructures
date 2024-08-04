package dev.joseafmoreira.base;

/**
 * This abstract class provides a skeletal implementation of the {@code AbstractDataType} 
 * interface, to implement the {@link #isEmpty()} and {@link #size()} 
 * methods that are equal in every abstract data type. <p>
 * 
 * To implement an abstract data type, the programmer needs to increment or 
 * decrement the {@link #size} value when adding or removing elements from the 
 * abstract data type
 * 
 * @author joseafmoreira
 * @see AbstractDataType
 * @since 2.0
 */
public abstract class AbstractDataTypeImpl implements AbstractDataType {
    /**
     * The number of elements in the abstract data type
     */
    protected int size;

    /**
     * Sole constructor. (For invocation by suclass constructors)
     */
    protected AbstractDataTypeImpl() {
        size = 0;
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
    public int size() {
        return size;
    }
}
