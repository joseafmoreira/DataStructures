package dev.joseafmoreira.entity.division;

import java.util.NoSuchElementException;

import dev.joseafmoreira.abstractdatatypes.lists.unordered.UnorderedArrayList;
import dev.joseafmoreira.entity.person.Person;
import dev.joseafmoreira.entity.person.PersonTitle;
import dev.joseafmoreira.exceptions.DivisionFullException;
import dev.joseafmoreira.exceptions.EmptyCollectionException;
import dev.joseafmoreira.exceptions.InvalidPermissionException;
import pt.ipp.estg.ed.UnorderedListADT;

/**
 * Represents a division within a hospital establishment. <p>
 * 
 * <h3>Division</h3>
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see Person
 */
public class Division {
    /**
     * The default allowed titles able to enter this division
     */
    private static final UnorderedListADT<PersonTitle> DEFAULT_ALLOWED_TITLES = new UnorderedArrayList<>(4);
    static {
        DEFAULT_ALLOWED_TITLES.addToRear(PersonTitle.MEDIC);
        DEFAULT_ALLOWED_TITLES.addToRear(PersonTitle.NURSE);
        DEFAULT_ALLOWED_TITLES.addToRear(PersonTitle.PATIENT);
        DEFAULT_ALLOWED_TITLES.addToRear(PersonTitle.VISITOR);
    }
    /**
     * The id that will be attributed to the next Division object
     */
    private static int NEXT_ID = 1;
    /**
     * This division's id
     */
    private final int id;
    /**
     * This division's name
     */
    private final String name;
    /**
     * This division's maximum capacity
     */
    private final int maxCapacity;
    /**
     * This division's allowed person positions
     */
    private final UnorderedListADT<PersonTitle> allowedTitles;
    /**
     * This division's people occupancy
     */
    private final UnorderedListADT<Person> peopleOccupancy;
    /**
     * This division's flag indicating whether this is a hospital exit or not
     */
    private final boolean isExit;

    /**
     * Constructs a division with a name, maximum capacity and a flag indicating if this is an exit or not.
     * 
     * @param name the name of this division
     * @param maxCapacity the max capacity of this division
     * @param isExit a flag indicating whether this division is an exit
     */
    public Division(String name, int maxCapacity, boolean isExit) {
        this(name, maxCapacity, DEFAULT_ALLOWED_TITLES, new UnorderedArrayList<>(maxCapacity), isExit);
    }

    /**
     * Constructs a division with a name, maximum capacity, list of allowed people titles inside this division 
     * and a flag indicating if this is an exit or not.
     * 
     * @param name the name of this division
     * @param maxCapacity the max capacity of this division
     * @param allowedTitles the allowed titles
     * @param isExit a flag indicating whether this division is an exit
     */
    public Division(String name, int maxCapacity, UnorderedListADT<PersonTitle> allowedTitles, boolean isExit) {
        this(name, maxCapacity, allowedTitles, new UnorderedArrayList<>(maxCapacity), isExit);
    }

    /**
     * Constructs a division with a name, maximum capacity, list of allowed people titles inside this division, 
     * list containing the people insie this division and a flag indicating if this is an exit or not.
     * 
     * @param name the name of this division
     * @param maxCapacity the max capacity of this division
     * @param allowedTitles the allowed titles 
     * @param peopleOccupancy the list of people inside this division
     * @param isExit a flag indicating whether this division is an exit
     * @throws NullPointerException if the name, allowed titles or the list of people occupancy is invalid
     */
    public Division(String name, int maxCapacity, UnorderedListADT<PersonTitle> allowedTitles, UnorderedListADT<Person> peopleOccupancy, boolean isExit) throws NullPointerException {
        if (name == null || name.strip() == "") throw new NullPointerException("Invalid name");
        if (allowedTitles == null) throw new NullPointerException("Invalid allowed titles");
        if (peopleOccupancy == null) throw new NullPointerException("Invalid people occupancy");

        id = NEXT_ID++;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.allowedTitles = allowedTitles;
        this.peopleOccupancy = peopleOccupancy;
        this.isExit = isExit;
    }

    /**
     * Adds a person to this division.
     * 
     * @param person the person to add
     * @throws NullPointerException if the person is null
     * @throws InvalidPermissionException if the person isn't allowed in this division
     * @throws DivisionFullException if this division is full
     */
    public void addPerson(Person person) throws NullPointerException, InvalidPermissionException, DivisionFullException {
        if (person == null) throw new NullPointerException("Person is null");
        if (!allowedTitles.contains(person.getTitle())) throw new InvalidPermissionException();
        if (getMaxCapacity() == peopleOccupancy.size()) throw new DivisionFullException();

        peopleOccupancy.addToRear(person);
    }

    /**
     * Removes a person from this division.
     * 
     * @param person the person to remove
     * @throws NullPointerException if the person is null
     * @throws NoSuchElementException if the person isn't in this division
     */
    public void removePerson(Person person) throws NullPointerException, NoSuchElementException {
        try {
            peopleOccupancy.remove(person);
        } catch (NullPointerException ex1) {
            throw new NullPointerException("Person is null");
        } catch (EmptyCollectionException ex2) {
            throw new NoSuchElementException("Person not found");
        } catch (NoSuchElementException ex3) {
            throw new NoSuchElementException("Person not found");
        }
    }

    /**
     * Returns the id of this division.
     * 
     * @return the id of this division
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of this division.
     * 
     * @return the name of this division
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the maximum capacity of this division.
     * 
     * @return the maximum capacity of this division
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Returns the allowed titles of this division.
     * 
     * @return the allowed titles of this division
     */
    public UnorderedListADT<PersonTitle> getAllowedTitles() {
        return allowedTitles;
    }

    /**
     * Returns the people occupancy of this division.
     * 
     * @return the people occupancy of this division
     */
    public UnorderedListADT<Person> getPeopleOccupancy() {
        return peopleOccupancy;
    }

    /**
     * Returns a flag indicating whether this division is an exit.
     * 
     * @return a flag indicating whether this division is an exit
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Returns a string representation of this division.
     * 
     * @return a string representation of this division
     */
    @Override
    public String toString() {
        return "ID: " + getId() + "\n" + 
               "Name: " + getName() + "\n" + 
               "Type: " + ((isExit()) ? "Exit" : "Division") + "\n" + 
               "Capacity: " + getPeopleOccupancy().size() + "/" + getMaxCapacity() + "\n" + 
               "Allowed titles: " + getAllowedTitles() + "\n" + 
               "People occupancy: " + getPeopleOccupancy();
    }
}
