package dev.joseafmoreira;

import dev.joseafmoreira.collection.tree.heap.LinkedMinHeap;
import pt.ipp.estg.ed.abstractdatatype.MinHeapADT;

public abstract class MinHeapTesting {
    public static void main(String[] args) {
        MinHeapADT<Integer> minheap = new LinkedMinHeap<>();
        System.out.println(minheap);
        minheap.add(2);
        minheap.add(3);
        minheap.add(4);
        minheap.add(1);
        System.out.println("Root element: " + minheap.findMin());
        System.out.println(minheap);
        System.out.println("Removed element: " + minheap.removeMin());
        System.out.println("Root element: " + minheap.findMin());
        System.out.println(minheap);
    }
}
