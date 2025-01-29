package dev.joseafmoreira.algorithm.sort;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Merge Sort is a sorting algorithm that follows the divide-and-conquer
 * approach. It works by recursively dividing the input array
 * into smaller subarrays and sorting those subarrays then merging them back
 * together to obtain the sorted array.
 * <p>
 * 
 * <h3>MergeSort</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class MergeSort {
    /**
     * Sorts the specified list using the MergeSort algorithm.
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
     * Sorts the specified array using the MergeSort algorithm.
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
     * Sorts the specified array using the MergeSort algorithm.
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
     * MergeSort algorithm implementation using a recursive approach.
     *
     * @param <T>      the type of elements in the array, which must extend
     *                 Comparable
     * @param array    the specified array
     * @param minIndex the starting index of the portion of the array to be sorted
     * @param maxIndex the ending index of the portion of the array to be sorted
     * @throws ClassCastException if the elements in the array aren't comparable
     */
    @SuppressWarnings("unchecked")
    private static <T> void sort(T[] array, int minIndex, int maxIndex) {
        if (minIndex == maxIndex)
            return;

        int i;
        int pivotIndex = (minIndex + maxIndex) / 2;
        int size = maxIndex - minIndex + 1;
        T[] tempArray = (T[]) new Comparable[size];
        sort(array, minIndex, pivotIndex);
        sort(array, pivotIndex + 1, maxIndex);
        for (i = 0; i < size; i++)
            tempArray[i] = array[minIndex + i];
        int leftIndex = 0;
        int rightIndex = pivotIndex - minIndex + 1;
        for (i = 0; i < size; i++)
            array[i + minIndex] = (rightIndex <= maxIndex - minIndex &&
                    (leftIndex > pivotIndex - minIndex
                            || ((Comparable<T>) tempArray[leftIndex]).compareTo(tempArray[rightIndex]) > 0))
                                    ? tempArray[rightIndex++]
                                    : tempArray[leftIndex++];
    }
}
