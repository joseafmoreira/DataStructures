package dev.joseafmoreira.algorithm.sort;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Insertion Sort is a simple sorting algorithm that works by iteratively
 * inserting each element of an unsorted list into its correct position in a
 * sorted portion of the list.
 * <p>
 * 
 * <h3>InsertionSort</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class InsertionSort {
    /**
     * Sorts the specified list using the InsertionSort algorithm.
     * 
     * @param <T>  the type of elements in the list, which must extend Comparable
     * @param list the specified list
     * @return an ordered array containing the elements of the list
     * @throws NullPointerException if the list is null
     * @throws ClassCastException   if the elements in the list aren't comparable
     */
    public static <T> T[] sort(ListADT<T> list) {
        if (list == null)
            throw new NullPointerException("List is null");
        T[] array = list.toArray();
        sort(array);
        return array;
    }

    /**
     * Sorts the specified array using the InsertionSort algorithm.
     * 
     * @param <T>   the type of elements in the array, which must extend Comparable
     * @param array the specified array
     * @throws NullPointerException if the array is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> void sort(T[] array) {
        sort(array, array.length);
    }

    /**
     * Sorts an array using the InsertionSort algorithm.
     * 
     * @param <T>    the type of elements in the array, which must extend Comparable
     * @param array  the specified array
     * @param length the specified length
     * @throws NullPointerException if the array is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    @SuppressWarnings("unchecked")
    public static <T> void sort(T[] array, int length) {
        if (array == null)
            throw new NullPointerException("Array is null");
        T key;
        int j;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i;
            while (j > 0 && ((Comparable<T>) array[j - 1]).compareTo(key) > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
    }
}
