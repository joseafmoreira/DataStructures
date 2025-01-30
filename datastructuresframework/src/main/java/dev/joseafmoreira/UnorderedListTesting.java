package dev.joseafmoreira;

import dev.joseafmoreira.collection.list.unordered.UnorderedArrayList;
import pt.ipp.estg.ed.abstractdatatype.UnorderedListADT;

public abstract class UnorderedListTesting {
    public static void main(String[] args) {
        UnorderedListADT<Integer> unorderedList = new UnorderedArrayList<>();
        unorderedList.addLast(3);
        unorderedList.addLast(2);
        unorderedList.addLast(5);
        unorderedList.addFirst(4);
        unorderedList.addAfter(7, 4);
        unorderedList.addAfter(9, 5);
        unorderedList.addAfter(6, 2);
        System.out.println(unorderedList);
        System.out.println("Removed element: " + unorderedList.removeFirst());
        System.out.println("Removed element: " + unorderedList.removeLast());
        System.out.println("Removed element: " + unorderedList.remove((Integer) 3));
        System.out.println(unorderedList);
        int element = 1;
        int index = unorderedList.size() - 1;
        System.out.println("Contains element " + element + ": " + unorderedList.contains(element));
        unorderedList.set(index, element);
        System.out.println(unorderedList);
        System.out.println("Contains element " + element + ": " + unorderedList.contains(element));
        unorderedList.sort();
        System.out.println(unorderedList);
        unorderedList.clear();
        System.out.println(unorderedList);
    }
}
