package dev.joseafmoreira;

import dev.joseafmoreira.abstractdatatype.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.abstractdatatype.list.unordered.UnorderedDoubleLinkedList;
import dev.joseafmoreira.abstractdatatype.list.unordered.UnorderedLinkedList;
import dev.joseafmoreira.algorithm.sorting.BubbleSort;
import dev.joseafmoreira.algorithm.sorting.InsertionSort;
import dev.joseafmoreira.algorithm.sorting.MergeSort;
import dev.joseafmoreira.algorithm.sorting.QuickSort;
import dev.joseafmoreira.algorithm.sorting.SelectionSort;
import pt.ipp.estg.ed.UnorderedListADT;

public class SortingTesting {
    private static final String CLASS = "DLINKED";
    private static final int CAPACITY = 0;

    public static void main(String[] args) {
        UnorderedListADT<Integer> unorderedList = (CLASS.equals("LINKED") ? new UnorderedLinkedList<>()
                : (CLASS.equals("DLINKED") ? new UnorderedDoubleLinkedList<>() : new UnorderedArrayList<>(CAPACITY)));
        unorderedList.addToRear(1);
        unorderedList.addToRear(3);
        unorderedList.addToRear(2);
        unorderedList.addToRear(5);
        unorderedList.addToFront(4);
        unorderedList.addAfter(7, 4);
        unorderedList.addAfter(9, 5);
        unorderedList.addAfter(6, 1);
        System.out.println(unorderedList);

        System.out.println(arrayToString(BubbleSort.bubbleSort(unorderedList)));
        System.out.println(arrayToString(SelectionSort.selectionSort(unorderedList)));
        System.out.println(arrayToString(InsertionSort.insertionSort(unorderedList)));
        System.out.println(arrayToString(MergeSort.mergeSort(unorderedList)));
        System.out.println(arrayToString(QuickSort.quickSort(unorderedList)));
    }

    private static String arrayToString(Object[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++)
            result.append(array[i]).append((i < array.length - 1) ? ", " : "");
        result.append("]");

        return result.toString();
    }
}
