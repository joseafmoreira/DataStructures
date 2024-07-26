package dev.joseafmoreira.adts;

/**
 * <h2>
 * OrderedListADT
 * </h2>
 * <p>
 * The {@code OrderedListADT} interface that specifies the behavior of an ordered list
 * </p>
 * <p>
 * This abstract data type extends {@link ListADT}
 * </p>
 * <p>
 * Author: ESTG-ED-2324
 * </p>
 */
public interface OrderedListADT<T> extends ListADT<T> {
    /**
     * Adds the specified element to this ordered list.
     *
     * @param element the element to be added to this ordered list
     * @throws NullPointerException if the specified element is null
     */
    void add(T element) throws NullPointerException;
}
