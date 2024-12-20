package dev.joseafmoreira;

import dev.joseafmoreira.abstractdatatype.queue.ArrayQueue;
import dev.joseafmoreira.abstractdatatype.queue.CircularArrayQueue;
import dev.joseafmoreira.abstractdatatype.queue.LinkedQueue;
import pt.ipp.estg.ed.QueueADT;

public class QueueTesting {
    private static final String CLASS = "CIRCULAR";
    private static final int CAPACITY = 0;

    public static void main(String[] args) {
        QueueADT<Integer> queue = (CLASS.equals("ARRAY") ? new ArrayQueue<>(CAPACITY)
                : (CLASS.equals("CIRCULAR") ? new CircularArrayQueue<>(CAPACITY) : new LinkedQueue<>()));
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(2);
        System.out.println(queue);

        System.out.println("Removed element: " + queue.dequeue());
        System.out.println(queue);
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println(queue);
    }
}
