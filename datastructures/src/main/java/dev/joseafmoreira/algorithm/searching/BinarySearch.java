package dev.joseafmoreira.algorithm.searching;

import dev.joseafmoreira.algorithm.CommonFunctions;
import pt.ipp.estg.ed.ListADT;

public abstract class BinarySearch {
    public static <T extends Comparable<? super T>> boolean binarySearch(ListADT<T> list, T target) {
        T[] array = CommonFunctions.toComparableArray(list);
        return binarySearch(array, target);
    }

    public static <T extends Comparable<? super T>> boolean binarySearch(T[] array, T target) {
        return binarySearch(array, 0, array.length - 1, target);
    }

    private static <T extends Comparable<? super T>> boolean binarySearch(T[] array, int minIndex, int maxIndex, T target) {
        if (minIndex <= maxIndex) {
            int midpoint = (minIndex + maxIndex) / 2;
            if (array[midpoint].compareTo(target) == 0)
                return true;
            else if (array[midpoint].compareTo(target) > 0) {
                return binarySearch(array, minIndex, midpoint - 1, target);
            } else
                return binarySearch(array, midpoint + 1, maxIndex, target);
        }
        return false;
    }
}
