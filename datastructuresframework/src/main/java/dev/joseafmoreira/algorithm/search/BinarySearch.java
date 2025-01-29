package dev.joseafmoreira.algorithm.search;

import pt.ipp.estg.ed.abstractdatatype.ListADT;

/**
 * Binary search is an efficient algorithm for finding a target 
 * within a sorted array. It works by repeatedly dividing the 
 * search interval in half. <p>
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
     */
    public static <T> boolean search(ListADT<? extends Comparable<? super T>> list, T target) {
        if (list == null)
            throw new NullPointerException("Array is null");
        if (target == null)
            throw new NullPointerException("Target is null");
        Comparable<? super T>[] array = list.toArray();
        return binarySearch(array, 0, array.length - 1, target);
    }

    public static <T extends Comparable<? super T>> boolean binarySearch(T[] array, T target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    @SuppressWarnings("unchecked")
    private static <T> boolean binarySearch(T[] array, int minIndex, int maxIndex, T target) {
        if (minIndex <= maxIndex) {
            int midpoint = (minIndex + maxIndex) / 2;
            if (((Comparable<T>) array[midpoint]).compareTo(target) == 0)
                return true;
            else if (((Comparable<T>) array[midpoint]).compareTo(target) > 0) {
                return binarySearch(array, minIndex, midpoint - 1, target);
            } else
                return binarySearch(array, midpoint + 1, maxIndex, target);
        }
        return false;
    }
}
