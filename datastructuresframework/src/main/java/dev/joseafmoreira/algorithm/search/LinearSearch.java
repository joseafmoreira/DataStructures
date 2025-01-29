package dev.joseafmoreira.algorithm.search;

import java.util.Iterator;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Linear, or sequential, search is a simple searching algorithm
 * that traverses a list or array sequentially to find a target.
 * <p>
 * 
 * <h3>LinearSearch</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class LinearSearch {
    /**
     * Performs a linear search on the specified list to find the specified target.
     *
     * @param <T>    the type of elements in the list and the target
     * @param list   the specified list
     * @param target the specified target
     * @return true if the target is found in the list, false otherwise
     * @throws NullPointerException if the list or target is null
     */
    public static <T> boolean search(ListADT<T> list, T target) {
        if (list == null)
            throw new NullPointerException("Array is null");
        if (target == null)
            throw new NullPointerException("Target is null");
        Iterator<T> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            T element = listIterator.next();
            if (element.equals(target))
                return true;
        }
        return false;
    }

    /**
     * Performs a linear search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array
     * @param array  the specified array
     * @param target the specified target
     * @return true if the target element is found in the array, false otherwise
     * @throws NullPointerException if the array or target is null
     */
    public static <T> boolean search(T[] array, T target) {
        return search(array, array.length, target);
    }

    /**
     * Performs a linear search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array
     * @param array  the specified array
     * @param length the specified length
     * @param target the specified target
     * @return true if the target element is found in the array, false otherwise
     * @throws NullPointerException if the array or target is null
     */
    public static <T> boolean search(T[] array, int length, T target) {
        if (array == null)
            throw new NullPointerException("Array is null");
        if (target == null)
            throw new NullPointerException("Target is null");
        for (int i = 0; i < length; i++)
            if (array[i].equals(target))
                return true;
        return false;
    }
}
