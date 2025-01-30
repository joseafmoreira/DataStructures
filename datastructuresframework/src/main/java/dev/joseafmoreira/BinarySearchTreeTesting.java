package dev.joseafmoreira;

import dev.joseafmoreira.collection.tree.search.LinkedBinarySearchTree;
import pt.ipp.estg.ed.abstractdatatype.BinarySearchTreeADT;

public abstract class BinarySearchTreeTesting {
    public static void main(String[] args) {
        BinarySearchTreeADT<Integer> binarySearchTree = new LinkedBinarySearchTree<>();
        binarySearchTree.add(7);
        binarySearchTree.add(2);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(8);
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        System.out.println(binarySearchTree);
        System.out.println("Removed element: " + binarySearchTree.remove(7));
        System.out.println("Removed element: " + binarySearchTree.removeMin());
        System.out.println("Removed element: " + binarySearchTree.removeMax());
        System.out.println("Root element: " + binarySearchTree.getRoot());
        System.out.println(binarySearchTree);
    }
}
