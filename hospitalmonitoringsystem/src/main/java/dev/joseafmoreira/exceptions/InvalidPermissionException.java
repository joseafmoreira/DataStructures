package dev.joseafmoreira.exceptions;

/**
 * Unchecked exception that can be thrown by some methods 
 * of a division indicating that a person has no permission 
 * for a certain task. <p>
 * 
 * The available constructors are the following: <p>
 * <ul>
 *  <li>{@link #InvalidPermissionException()}: Constructs a new InvalidPermissionException with a default message</li>
 * </ul>
 * 
 * <h3>InvalidPermissionException</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see RuntimeException
 */
public class InvalidPermissionException extends RuntimeException {
    /**
     * The default message of this exception
     */
    protected static final String DEFAULT_MESSAGE = "Person not allowed in this division";

    /**
     * Constructs a new InvalidPermissionException with a default message.
     */
    public InvalidPermissionException() {
        super(DEFAULT_MESSAGE);
    }
}
