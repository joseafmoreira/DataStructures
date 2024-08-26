package dev.joseafmoreira.entity.person;

/**
 * Represents a person within the hospital establishment who can move between different divisions. <p>
 * 
 * This class encapsulates the essential attributes of a person, including their id and title
 * within the hospital. The title of the person is defined by the {@link PersonTitle} enumeration. <p>
 * 
 * The expected operations for a person include:
 * <ul>
 *  <li>{@link #getId()}: Returns the id of this person</li>
 *  <li>{@link #getTitle()}: Returns the title of this person</li>
 *  <li>{@link #setTitle(PersonTitle)}: Sets the title of this person</li>
 *  <li>{@link #toString()}: Returns a string representation of this person</li>
 * </ul>
 * 
 * <h3>Person</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see PersonTitle
 */
public class Person {
    /**
     * The id that will be attributed to the next Person object
     */
    private static int NEXT_ID = 1;
    /**
     * This person's id
     */
    private final int id;
    /**
     * This person's title
     */
    private PersonTitle title;

    /**
     * Constructs a person with a title.
     * 
     * @param title the title of this person
     */
    public Person(PersonTitle title) {
        id = NEXT_ID++;
        setTitle(title);
    }

    /**
     * Returns the id of this person.
     * 
     * @return the id of this person
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the title of this person.
     * 
     * @return the title of this person
     */
    public PersonTitle getTitle() {
        return title;
    }

    /**
     * Sets the title of this person.
     * 
     * @param title the person title to be set
     */
    public void setTitle(PersonTitle title) {
        this.title = title;
    }

    /**
     * Returns a string representation of this person.
     * 
     * @return a string representation of this person
     */
    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
