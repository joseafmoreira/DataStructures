package dev.joseafmoreira.exceptions;

/**
 * Unchecked exception that can be thrown by some methods 
 * of a division indicating that the division is full. <p> 
 * 
 * The available constructors are the following: <p>
 * <ul>
 *  <li>{@link #DivisionFullException()}: Constructs a new DivisionFullException with a default message</li>
 * </ul>
 * 
 * <h3>DivisionFullException</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see RuntimeException
 */
public class DivisionFullException extends RuntimeException {
    /**
     * The default message of this exception
     */
    protected static final String DEFAULT_MESSAGE = "Division is full";

    /**
     * Constructs a new DivisionFullException with a default message.
     */
    public DivisionFullException() {
        super(DEFAULT_MESSAGE);
    }
}
