package dev.joseafmoreira;

import dev.joseafmoreira.collection.stack.LinkedStack;
import pt.ipp.estg.ed.abstractdatatype.StackADT;

public class StackTesting {
    public static void main(String[] args) {
        StackADT<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(stack);
        System.out.println("Removed element: " + stack.pop());
        System.out.println("Removed element: " + stack.pop());
        System.out.println(stack);
    }
}
