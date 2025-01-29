package dev.joseafmoreira;

import dev.joseafmoreira.collection.list.unordered.UnorderedArrayList;
import pt.ipp.estg.ed.abstractdatatype.UnorderedListADT;

public class UnorderedListTesting {
    public static void main(String[] args) {
        UnorderedListADT<Integer> unorderedList = new UnorderedArrayList<>();
        unorderedList.addToRear(1);
        unorderedList.addToRear(3);
        unorderedList.addToRear(2);
        unorderedList.addToRear(5);
        unorderedList.addToFront(4);
        unorderedList.addAfter(7, 4);
        unorderedList.addAfter(9, 5);
        unorderedList.addAfter(6, 1);
        System.out.println(unorderedList);
        System.out.println("Removed element: " + unorderedList.removeFirst());
        System.out.println("Removed element: " + unorderedList.removeLast());
        System.out.println("Removed element: " + unorderedList.remove((Integer) 3));
        System.out.println(unorderedList);
    }
}
