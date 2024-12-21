package dev.joseafmoreira.algorithm.sorting;

import dev.joseafmoreira.algorithm.CommonFunctions;
import pt.ipp.estg.ed.ListADT;

/**
 * An abstract class that implements the QuickSort algorithm.
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class QuickSort {
    /**
     * Sorts a {@code ListADT} using the QuickSort algorithm.
     * 
     * @param <T>  the type of elements in the list, which must extend Comparable
     * @param list the list to be sorted
     * @return an ordered array containing the elements of the list
     */
    public static <T extends Comparable<? super T>> T[] quickSort(ListADT<T> list) {
        T[] array = CommonFunctions.toComparableArray(list);
        return quickSort(array);
    }

    /**
     * Sorts an array using the QuickSort algorithm.
     * 
     * @param <T>   the type of elements in the array, which must extend Comparable
     * @param array the array to be sorted
     * @return the ordered array
     */
    public static <T extends Comparable<? super T>> T[] quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Sorts the specified array using the QuickSort algorithm.
     *
     * @param <T>      the type of elements in the array, which must be comparable
     * @param array    the array to be sorted
     * @param minIndex the starting index of the portion of the array to be sorted
     * @param maxIndex the ending index of the portion of the array to be sorted
     */
    private static <T extends Comparable<? super T>> void quickSort(T[] array, int minIndex, int maxIndex) {
        if (maxIndex - minIndex > 0) {
            int partitionIndex = findPartitionIndex(array, minIndex, maxIndex);
            quickSort(array, minIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, maxIndex);
        }
    }

    /**
     * Finds the partition index for the QuickSort algorithm.
     * This method partitions the array into two parts based on the pivot element.
     * Elements less than the pivot are moved to the left of the pivot, and elements
     * greater than the pivot are moved to the right.
     *
     * @param <T>      the type of elements in the array, which must be comparable
     * @param array    the array to be partitioned
     * @param minIndex the starting index of the portion of the array to be
     *                 partitioned
     * @param maxIndex the ending index of the portion of the array to be
     *                 partitioned
     * @return the index of the partition element after partitioning
     */
    private static <T extends Comparable<? super T>> int findPartitionIndex(T[] array, int minIndex, int maxIndex) {
        T partitionElement = array[maxIndex];
        int leftIndex = minIndex;
        int rightIndex = maxIndex - 1;
        while (leftIndex <= rightIndex) {
            while (array[leftIndex].compareTo(partitionElement) < 0)
                leftIndex++;
            while (array[rightIndex].compareTo(partitionElement) > 0)
                rightIndex--;
            if (leftIndex <= rightIndex) {
                CommonFunctions.swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        CommonFunctions.swap(array, leftIndex, maxIndex);

        return leftIndex;
    }
}
