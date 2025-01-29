package dev.joseafmoreira.algorithm.search;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Binary search is an efficient algorithm for finding a target
 * within a sorted array. It works by repeatedly dividing the
 * search interval in half.
 * <p>
 * 
 * <h3>BinarySearch</h3>
 * 
 * @since 1.0
 * @version 1.0
 * @author joseafmoreira
 * @see ListADT
 */
public abstract class BinarySearch {
    /**
     * Performs a binary search on the specified list to find the specified target.
     *
     * @param <T>    the type of elements in the list and the target
     * @param list   the specified list
     * @param target the specified target
     * @return true if the target is found in the list, false otherwise
     * @throws NullPointerException if the list or target is null
     * @throws ClassCastException   if the elements in the list aren't comparable
     */
    public static <T> boolean search(ListADT<T> list, T target) {
        if (list == null)
            throw new NullPointerException("List is null");
        if (target == null)
            throw new NullPointerException("Target is null");
        T[] array = list.toArray();
        return search(array, target);
    }

    /**
     * Performs a binary search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array and the target
     * @param array  the specified array
     * @param target the specified target
     * @return true if the target is found in the array, false otherwise
     * @throws NullPointerException if the array or target is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> boolean search(T[] array, T target) {
        return search(array, array.length, target);
    }

    /**
     * Performs a binary search on the specified array to find the specified target.
     *
     * @param <T>    the type of elements in the array and the target
     * @param array  the specified array
     * @param length the specified length
     * @param target the specified target
     * @return true if the target is found in the array, false otherwise
     * @throws NullPointerException if the array or target is null
     * @throws ClassCastException   if the elements in the array aren't comparable
     */
    public static <T> boolean search(T[] array, int length, T target) {
        if (array == null)
            throw new NullPointerException("Array is null");
        if (target == null)
            throw new NullPointerException("Target is null");
        return search(array, 0, length - 1, target);
    }

    /**
     * Binary search algorithm implementation using a recursive approach.
     *
     * @param <T>      the type of elements in the array, which must be comparable
     * @param array    the specified array
     * @param minIndex the minimum index of the array segment to search
     * @param maxIndex the maximum index of the array segment to search
     * @param target   the specified target
     * @return true if the target is found, false otherwise
     * @throws ClassCastException if the elements in the array aren't comparable
     */
    @SuppressWarnings("unchecked")
    private static <T> boolean search(T[] array, int minIndex, int maxIndex, T target) {
        if (minIndex <= maxIndex) {
            int midpoint = (minIndex + maxIndex) / 2;
            if (((Comparable<T>) array[midpoint]).compareTo(target) == 0)
                return true;
            else if (((Comparable<T>) array[midpoint]).compareTo(target) > 0) {
                return search(array, minIndex, midpoint - 1, target);
            } else
                return search(array, midpoint + 1, maxIndex, target);
        }
        return false;
    }
}
