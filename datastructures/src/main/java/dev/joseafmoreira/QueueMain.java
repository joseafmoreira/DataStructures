package dev.joseafmoreira;

import dev.joseafmoreira.abstractdatatypes.queues.LinkedQueue;
import pt.ipp.estg.ed.QueueADT;

public class QueueMain {
    public static void main(String[] args) {
        QueueADT<Integer> queue = new LinkedQueue<>();
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue);

        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
