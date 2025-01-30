package dev.joseafmoreira;

import dev.joseafmoreira.collection.tree.heap.LinkedMaxHeap;
import pt.ipp.estg.ed.abstractdatatype.MaxHeapADT;

public abstract class MaxHeapTesting {
    public static void main(String[] args) {
        MaxHeapADT<Integer> maxheap = new LinkedMaxHeap<>();
        System.out.println(maxheap);
        maxheap.add(2);
        maxheap.add(3);
        maxheap.add(4);
        maxheap.add(1);
        System.out.println("Root element: " + maxheap.findMax());
        System.out.println(maxheap);
        System.out.println("Removed element: " + maxheap.removeMax());
        System.out.println("Root element: " + maxheap.findMax());
        System.out.println(maxheap);
    }
}
