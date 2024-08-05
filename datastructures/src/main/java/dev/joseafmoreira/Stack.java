package dev.joseafmoreira;

import dev.joseafmoreira.stacks.ArrayStack;
import dev.joseafmoreira.stacks.LinkedStack;
import pt.ipp.estg.ed.StackADT;

public class Stack {
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
