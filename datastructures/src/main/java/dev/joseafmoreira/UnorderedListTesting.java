package dev.joseafmoreira;

import java.util.NoSuchElementException;

import dev.joseafmoreira.abstractdatatype.list.unordered.UnorderedArrayList;
import dev.joseafmoreira.abstractdatatype.list.unordered.UnorderedDoubleLinkedList;
import dev.joseafmoreira.abstractdatatype.list.unordered.UnorderedLinkedList;
import dev.joseafmoreira.exception.EmptyCollectionException;
import pt.ipp.estg.ed.UnorderedListADT;

public class UnorderedListTesting {
    private static final String CLASS = "DLINKED";
    private static final int CAPACITY = 0;

    public static void main(String[] args) {
        UnorderedListADT<Integer> unorderedList = (CLASS.equals("LINKED") ? new UnorderedLinkedList<>()
                : (CLASS.equals("DLINKED") ? new UnorderedDoubleLinkedList<>() : new UnorderedArrayList<>(CAPACITY)));
        try {
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
            System.out.println("Removed element: " + unorderedList.remove(3));
            System.out.println(unorderedList);
        } catch (EmptyCollectionException | NullPointerException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
