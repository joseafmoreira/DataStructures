package dev.joseafmoreira;

import dev.joseafmoreira.collection.queue.LinkedQueue;
import pt.ipp.estg.ed.abstractdatatype.QueueADT;

public abstract class QueueTesting {
    public static void main(String[] args) {
        QueueADT<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println(queue);
    }
}
