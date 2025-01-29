package dev.joseafmoreira.algorithm.sort;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in the wrong order.
 * <p>
 * 
 * <h3>BubbleSort</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class BubbleSort {
    /**
     * Sorts the specified list using the BubbleSort algorithm.
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
     * Sorts the specified array using the BubbleSort algorithm.
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
     * Sorts an array using the BubbleSort algorithm.
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
        for (int i = length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++)
                if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0)
                    SortingFunctions.swap(array, j, j + 1);
    }
}
