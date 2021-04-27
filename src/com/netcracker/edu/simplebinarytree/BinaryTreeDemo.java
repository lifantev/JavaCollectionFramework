package com.netcracker.edu.simplebinarytree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.add(7);
        System.out.println(bt.depth()); // must be 1
        bt.add(4);
        bt.add(3);
        bt.add(5);
        System.out.println(bt.size()); // must be 4
        bt.add(6);
        bt.add(1);
        System.out.println(bt.size()); // must be 6

        System.out.println(bt.add(4)); //must be false
        System.out.println(bt.add(7)); // must be false

        bt.add(11);
        bt.add(9);
        bt.add(12);
        bt.add(10);
        bt.add(8);
        System.out.println(bt.size()); // must be 11

        /*
            bt:
                        7
                  4            11
                3   5       9      12
              1       6   8   10

         */

        bt.traverseInOrder().forEach(data -> System.out.print(data + " "));
        System.out.println();

        bt.traversePreOrder().forEach(data -> System.out.print(data + " "));
        System.out.println();

        bt.traversePostOrder().forEach(data -> System.out.print(data + " "));
        System.out.println();
    }
}
