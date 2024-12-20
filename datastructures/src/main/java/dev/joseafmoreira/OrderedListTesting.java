package dev.joseafmoreira;

import dev.joseafmoreira.abstractdatatype.list.ordered.OrderedArrayList;
import dev.joseafmoreira.abstractdatatype.list.ordered.OrderedDoubleLinkedList;
import dev.joseafmoreira.abstractdatatype.list.ordered.OrderedLinkedList;
import pt.ipp.estg.ed.OrderedListADT;

public class OrderedListTesting {
    private static final String CLASS = "DLINKED";
    private static final int CAPACITY = 0;

    public static void main(String[] args) {
        OrderedListADT<Integer> orderedList = (CLASS.equals("LINKED") ? new OrderedLinkedList<>()
                : (CLASS.equals("DLINKED") ? new OrderedDoubleLinkedList<>() : new OrderedArrayList<>(CAPACITY)));
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(2);
        orderedList.add(5);
        orderedList.add(4);
        System.out.println(orderedList);

        System.out.println("Removed element: " + orderedList.removeFirst());
        System.out.println("Removed element: " + orderedList.removeLast());
        System.out.println("Removed element: " + orderedList.remove(3));
        System.out.println(orderedList);
    }
}
