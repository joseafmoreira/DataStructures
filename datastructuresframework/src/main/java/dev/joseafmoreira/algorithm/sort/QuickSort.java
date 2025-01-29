package dev.joseafmoreira.algorithm.sort;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Quick Sort is a sorting algorithm based on the Divide and Conquer that picks
 * an element as a pivot and partitions the given array around the picked pivot
 * by placing the pivot in its correct position in the sorted array.
 * <p>
 * 
 * <h3>QuickSort</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class QuickSort {
    /**
     * Sorts the specified list using the QuickSort algorithm.
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
     * Sorts the specified array using the QuickSort algorithm.
     * 
     * @param <T>  the type of elements in the array, which must extend Comparable
     * @param array the specified array
     * @throws NullPointerException if the array is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> void sort(T[] array) {
        sort(array, array.length);
    }

    /**
     * Sorts the specified array using the QuickSort algorithm.
     * 
     * @param <T>  the type of elements in the array, which must extend Comparable
     * @param array the specified array
     * @param length the length of the array
     * @throws NullPointerException if the array is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> void sort(T[] array, int length) {
        if (array == null)
            throw new NullPointerException("Array is null");
        sort(array, 0, length - 1);
    }

    /**
     * QuickSort algorithm implementation using a recursive approach.
     *
     * @param <T>      the type of elements in the array, which must be comparable
     * @param array    the specified array
     * @param minIndex the starting index of the portion of the array to be sorted
     * @param maxIndex the ending index of the portion of the array to be sorted
     * @throws ClassCastException if the elements in the array aren't comparable
     */
    private static <T> void sort(T[] array, int minIndex, int maxIndex) {
        if (maxIndex - minIndex > 0) {
            int partitionIndex = findPartitionIndex(array, minIndex, maxIndex);
            sort(array, minIndex, partitionIndex - 1);
            sort(array, partitionIndex + 1, maxIndex);
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
     * @throws ClassCastException if the elements in the array aren't comparable
     */
    @SuppressWarnings("unchecked")
    private static <T> int findPartitionIndex(T[] array, int minIndex, int maxIndex) {
        T partitionElement = array[maxIndex];
        int leftIndex = minIndex;
        int rightIndex = maxIndex - 1;
        while (leftIndex <= rightIndex) {
            while (((Comparable<T>) array[leftIndex]).compareTo(partitionElement) < 0)
                leftIndex++;
            while (rightIndex >= minIndex && ((Comparable<T>) array[rightIndex]).compareTo(partitionElement) > 0)
                rightIndex--;
            if (leftIndex <= rightIndex) {
                SortingFunctions.swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        SortingFunctions.swap(array, leftIndex, maxIndex);
        return leftIndex;
    }
}
