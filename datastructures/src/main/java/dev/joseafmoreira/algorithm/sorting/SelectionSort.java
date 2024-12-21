package dev.joseafmoreira.algorithm.sorting;

import dev.joseafmoreira.algorithm.CommonFunctions;
import pt.ipp.estg.ed.ListADT;

/**
 * An abstract class that implements the SelectionSort algorithm.
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class SelectionSort {
    /**
     * Sorts a {@code ListADT} using the SelectionSort algorithm.
     * 
     * @param <T>  the type of elements in the list, which must extend Comparable
     * @param list the list to be sorted
     * @return an ordered array containing the elements of the list
     */
    public static <T extends Comparable<? super T>> T[] selectionSort(ListADT<T> list) {
        T[] array = CommonFunctions.toComparableArray(list);
        return selectionSort(array);
    }

    /**
     * Sorts an array using the SelectionSort algorithm.
     * 
     * @param <T>   the type of elements in the array, which must extend Comparable
     * @param array the array to be sorted
     * @return the ordered array
     */
    public static <T extends Comparable<? super T>> T[] selectionSort(T[] array) {
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j].compareTo(array[minIndex]) < 0)
                    minIndex = j;
            CommonFunctions.swap(array, minIndex, i);
        }

        return array;
    }
}
