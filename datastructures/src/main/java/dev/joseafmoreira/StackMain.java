package dev.joseafmoreira;

import dev.joseafmoreira.abstractdatatypes.stacks.LinkedStack;
import pt.ipp.estg.ed.StackADT;

public class StackMain {
    public static void main(String[] args) {
        StackADT<Integer> stack = new LinkedStack<>();
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack);

        stack.push(1);
        stack.push(2);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
