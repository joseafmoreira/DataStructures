package dev.joseafmoreira;

import dev.joseafmoreira.collection.tree.priorityqueue.LinkedMinPriorityQueue;
import pt.ipp.estg.ed.abstractdatatype.PriorityQueueADT;

public abstract class MinPriorityQueueTesting {
    public static void main(String[] args) {
        PriorityQueueADT<Integer> minPriorityQueue = new LinkedMinPriorityQueue<>();
        minPriorityQueue.add(2, 1);
        minPriorityQueue.add(1, 0);
        System.out.println(minPriorityQueue);
        System.out.println("Removed element: " + minPriorityQueue.remove());
        System.out.println(minPriorityQueue);
    }
}
