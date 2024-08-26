package dev.joseafmoreira.entity.person;

/**
 * This enumerates the possible options for a person title in the hospital establishment. <p>
 * 
 * The available operations are: <p>
 * <ul>
 *  <li>{@link #toString()}: Returns a string representation of this person title</li>
 * </ul>
 * 
 * <h3>PersonTitle</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see Person
 */
public enum PersonTitle {
    /**
     * Administrative person title
     */
    ADMINISTRATIVE,
    /**
     * Medic person title
     */
    MEDIC,
    /**
     * Nurse person title
     */
    NURSE,
    /**
     * Patient person title
     */
    PATIENT,
    /**
     * Visitor person title
     */
    VISITOR;

    /**
     * Returns a string representation of this person title.
     * 
     * @return a string representation of this person title
     */
    @Override
    public String toString() {
        return switch (this) {
            case ADMINISTRATIVE -> "Administrative";
            case MEDIC -> "Medic";
            case NURSE -> "Nurse";
            case PATIENT -> "Patient";
            case VISITOR -> "Visitor";
        };
    }
}
