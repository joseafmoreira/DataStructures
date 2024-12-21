package dev.joseafmoreira.algorithm.sorting;

import dev.joseafmoreira.algorithm.CommonFunctions;
import pt.ipp.estg.ed.ListADT;

/**
 * An abstract class that implements the MergeSort algorithm.
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class MergeSort {
    /**
     * Sorts a {@code ListADT} using the MergeSort algorithm.
     * 
     * @param <T>  the type of elements in the list, which must extend Comparable
     * @param list the list to be sorted
     * @return an ordered array containing the elements of the list
     */
    public static <T extends Comparable<? super T>> T[] mergeSort(ListADT<T> list) {
        T[] array = CommonFunctions.toComparableArray(list);
        return mergeSort(array);
    }

    /**
     * Sorts an array using the MergeSort algorithm.
     * 
     * @param <T>   the type of elements in the array, which must extend Comparable
     * @param array the array to be sorted
     * @return the ordered array
     */
    public static <T extends Comparable<? super T>> T[] mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Sorts an array using the MergeSort algorithm.
     *
     * @param <T>      the type of elements in the array, which must extend
     *                 Comparable
     * @param array    the array to be sorted
     * @param minIndex the starting index of the portion of the array to be sorted
     * @param maxIndex the ending index of the portion of the array to be sorted
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<? super T>> void mergeSort(T[] array, int minIndex, int maxIndex) {
        if (minIndex == maxIndex)
            return;

        int i;
        int pivotIndex = (minIndex + maxIndex) / 2;
        int size = maxIndex - minIndex + 1;
        T[] tempArray = (T[]) new Comparable[size];
        mergeSort(array, minIndex, pivotIndex);
        mergeSort(array, pivotIndex + 1, maxIndex);
        for (i = 0; i < size; i++)
            tempArray[i] = array[minIndex + i];
        int leftIndex = 0;
        int rightIndex = pivotIndex - minIndex + 1;
        for (i = 0; i < size; i++) {
            array[i + minIndex] = (rightIndex <= maxIndex - minIndex &&
                    (leftIndex > pivotIndex - minIndex || tempArray[leftIndex].compareTo(tempArray[rightIndex]) > 0))
                            ? tempArray[rightIndex++]
                            : tempArray[leftIndex++];
        }
    }
}
