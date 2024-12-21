package dev.joseafmoreira.algorithm.sorting;

import dev.joseafmoreira.algorithm.CommonFunctions;
import pt.ipp.estg.ed.ListADT;

/**
 * An abstract class that implements the BubbleSort algorithm.
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class BubbleSort {
    /**
     * Sorts a {@code ListADT} using the BubbleSort algorithm.
     * 
     * @param <T> the type of elements in the list, which must extend Comparable
     * @param list the list to be sorted
     * @return an ordered array containing the elements of the list
     */
    public static <T extends Comparable<? super T>> T[] bubbleSort(ListADT<T> list) {
        T[] array = CommonFunctions.toComparableArray(list);
        return bubbleSort(array);
    }

    /**
     * Sorts an array using the BubbleSort algorithm.
     * 
     * @param <T> the type of elements in the array, which must extend Comparable
     * @param array the array to be sorted
     * @return the ordered array
     */
    public static <T extends Comparable<? super T>> T[] bubbleSort(T[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++)
                if (array[j].compareTo(array[j + 1]) > 0)
                    CommonFunctions.swap(array, j, j + 1);

        return array;
    }
}
