package dev.joseafmoreira;

import dev.joseafmoreira.collection.tree.priorityqueue.LinkedMaxPriorityQueue;
import pt.ipp.estg.ed.abstractdatatype.PriorityQueueADT;

public abstract class MaxPriorityQueueTesting {
    public static void main(String[] args) {
        PriorityQueueADT<Integer> minPriorityQueue = new LinkedMaxPriorityQueue<>();
        minPriorityQueue.add(2, 1);
        minPriorityQueue.add(1, 0);
        System.out.println(minPriorityQueue);
        System.out.println("Removed element: " + minPriorityQueue.remove());
        System.out.println(minPriorityQueue);
    }
}
