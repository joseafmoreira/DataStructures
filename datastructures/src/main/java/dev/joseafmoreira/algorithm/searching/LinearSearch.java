package dev.joseafmoreira.algorithm.searching;

import java.util.Iterator;

import pt.ipp.estg.ed.ListADT;

public abstract class LinearSearch {
    public static <T> boolean linearSearch(ListADT<T> list, T target) {
        Iterator<T> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            T element = listIterator.next();
            if (element.equals(target))
                return true;
        }
        return false;
    }

    public static <T> boolean linearSearch(T[] array, T target) {
        for (T element : array)
            if (element.equals(target))
                return true;
        return false;
    }
}
