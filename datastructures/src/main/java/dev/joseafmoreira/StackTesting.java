package dev.joseafmoreira;

import dev.joseafmoreira.abstractdatatype.stack.ArrayStack;
import dev.joseafmoreira.abstractdatatype.stack.LinkedStack;
import pt.ipp.estg.ed.StackADT;

public class StackTesting {
    private static final String CLASS = "ARRAY";
    private static final int CAPACITY = 0;

    public static void main(String[] args) {
        StackADT<Integer> stack = (CLASS.equals("ARRAY") ? new ArrayStack<>(CAPACITY) : new LinkedStack<>());
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
