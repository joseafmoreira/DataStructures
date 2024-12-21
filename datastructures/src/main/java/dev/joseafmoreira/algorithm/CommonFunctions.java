package dev.joseafmoreira.algorithm;

import pt.ipp.estg.ed.ListADT;

/**
 * An abstract class that implements all the common functions used in the
 * searching / sorting algorithms.
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class CommonFunctions {
    /**
     * Converts a list to an array.
     *
     * @param <T>  the type of elements in the list
     * @param list the list to be converted to an array
     * @return an array containing all the elements in the list
     * @throws NullPointerException if the list is null
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(ListADT<T> list) throws NullPointerException {
        if (list == null)
            throw new NullPointerException("List is null");
        T[] result = (T[]) new Object[list.size()];
        int i = 0;
        for (T element : list)
            result[i++] = element;

        return result;
    }

    /**
     * Converts a list to a comparable array.
     *
     * @param <T>  the type of elements in the list, which must extend Comparable
     * @param list the list to be converted to an array
     * @return an array containing all the elements in the list
     * @throws NullPointerException if the list is null
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> T[] toComparableArray(ListADT<T> list) throws NullPointerException {
        if (list == null)
            throw new NullPointerException("List is null");
        T[] result = (T[]) new Comparable[list.size()];
        int i = 0;
        for (T element : list)
            result[i++] = element;

        return result;
    }

    /**
     * Swaps the elements at the specified positions in the specified array.
     *
     * @param <T>   the type of the elements in the array
     * @param array the array in which to swap elements
     * @param i     the index of one element to be swapped
     * @param j     the index of the other element to be swapped
     * @throws ArrayIndexOutOfBoundsException if either i or j is out of range
     */
    public static <T> void swap(T[] array, int i, int j) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= array.length)
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of range");
        if (j < 0 || j >= array.length)
            throw new ArrayIndexOutOfBoundsException("Index " + j + " out of range");
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
