package dev.joseafmoreira.exceptions;

/**
 * <h2>
 * EmptyCollectionException
 * </h2>
 * <p>
 * The <code>EmptyCollectionException</code> unchecked exception is thrown when attempting to perform an operation on an empty collection.
 * </p>
 * <p>
 * The <code>EmptyCollectionException</code> extends {@link RuntimeException}
 * </p>
 * <p>
 * Author: joseafmoreira
 * </p>
 */
public class EmptyCollectionException extends RuntimeException {
    /**
     * Constructs an EmptyCollectionException with the specified detail message.
     *
     * @param message the specified message
     */
    public EmptyCollectionException(String message) {
        super(message);
    }
}
