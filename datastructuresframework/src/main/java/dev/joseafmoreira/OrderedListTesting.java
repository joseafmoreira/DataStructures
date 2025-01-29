package dev.joseafmoreira;

import dev.joseafmoreira.collection.list.ordered.OrderedArrayList;
import pt.ipp.estg.ed.abstractdatatype.OrderedListADT;

public class OrderedListTesting {
    public static void main(String[] args) {
        OrderedListADT<Integer> orderedList = new OrderedArrayList<>();
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(2);
        orderedList.add(5);
        orderedList.add(4);
        System.out.println(orderedList);
        System.out.println("Removed element: " + orderedList.removeFirst());
        System.out.println("Removed element: " + orderedList.removeLast());
        System.out.println("Removed element: " + orderedList.remove((Integer) 3));
        System.out.println(orderedList);
    }
}
