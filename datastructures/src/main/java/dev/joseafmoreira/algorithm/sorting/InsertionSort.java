package dev.joseafmoreira.algorithm.sorting;

import dev.joseafmoreira.algorithm.CommonFunctions;
import pt.ipp.estg.ed.ListADT;

/**
 * An abstract class that implements the InsertionSort algorithm.
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class InsertionSort {
    /**
     * Sorts a {@code ListADT} using the InsertionSort algorithm.
     * 
     * @param <T> the type of elements in the list, which must extend Comparable
     * @param list the list to be sorted
     * @return an ordered array containing the elements of the list
     */
    public static <T extends Comparable<? super T>> T[] insertionSort(ListADT<T> list) {
        T[] array = CommonFunctions.toComparableArray(list);
        return insertionSort(array);
    }

    /**
     * Sorts an array using the InsertionSort algorithm.
     * 
     * @param <T> the type of elements in the array, which must extend Comparable
     * @param array the array to be sorted
     * @return the ordered array
     */
    public static <T extends Comparable<? super T>> T[] insertionSort(T[] array) {
        T key;
        int j;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i;
            while (j > 0 && array[j - 1].compareTo(key) > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }

        return array;
    }
}
