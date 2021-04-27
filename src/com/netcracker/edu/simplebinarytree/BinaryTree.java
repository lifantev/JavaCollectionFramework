package com.netcracker.edu.simplebinarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree.
 * @param <T> extends {@code Comparable<T>}
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    /**
     * Default constructor.
     */
    public BinaryTree() {
    }

    /**
     * Constructor specifying root's data.
     * @param data
     */
    public BinaryTree(T data) {
        root = new Node<>(data);
    }

    /**
     * Getter for root.
     * @return
     */
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Checks empty tree or not.
     * @return true if empty, false if not.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns number of Nodes in BT.
     * @return
     */
    public int size() {
        return traverseInOrder().size();
    }

    /**
     * Adds new Node in BT with specified data.
     * @param data
     * @return true if new data was added,
     * false if Node with this data already exists.
     */
    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> tempNode = root;
            Node<T> prevNode = null;

            while (tempNode != null) {
                prevNode = tempNode;
                if (data.compareTo(tempNode.getData()) > 0) {
                    tempNode = tempNode.getRight();
                } else if (data.compareTo(tempNode.getData()) < 0) {
                    tempNode = tempNode.getLeft();
                } else {
                    return false;
                }
            }

            if (data.compareTo(prevNode.getData()) < 0) {
                prevNode.setLeft(newNode);
            } else {
                prevNode.setRight(newNode);
            }
        }
        return true;
    }

    /**
     * Finds Node with specified data in BT.
     * @param data
     * @return found Node or null if wasn't found.
     */
    public Node<T> find(T data)
    {
        Node<T> node = root;
        while (node != null && node.getData() != data)
        {
            if (data.compareTo(node.getData()) < 0)
                node = node.getLeft();
            else
                node = node.getRight();
        }
        return node;
    }

    /**
     * Provides in-order tree traversal.
     * Which consists of first visiting the left subtree,
     * then the root node, and finally the right subtree.
     * @return {@code List<T>} of data from traversed Nodes.
     */
    public List<T> traverseInOrder() {
        List<T> dataList = new LinkedList<>();
        traverseInOrder(root, dataList);
        return dataList;
    }

    /**
     * Provides pre-order tree traversal.
     * Which consists of first visiting the root node,
     * then the left subtree, and finally the right subtree.
     * @return {@code List<T>} of data from traversed Nodes.
     */
    public List<T> traversePreOrder() {
        List<T> dataList = new LinkedList<>();
        traversePreOrder(root, dataList);
        return dataList;
    }

    /**
     * Provides post-order tree traversal.
     * Which consists of first visiting the left subtree,
     * then the right subtree, and the root node at the end.
     * @return {@code List<T>} of data from traversed Nodes.
     */
    public List<T> traversePostOrder() {
        List<T> dataList = new LinkedList<>();
        traversePostOrder(root, dataList);
        return dataList;
    }

    /**
     * In-order tree traversal begins from argument root,
     * all data from visited Nodes is added to dataList.
     * @param root
     * @param dataList
     */
    private void traverseInOrder(Node<T> root, List<T> dataList) {
        if (root != null) {
            traverseInOrder(root.getLeft(), dataList);
            dataList.add(root.getData());
            traverseInOrder(root.getRight(), dataList);
        }
    }

    /**
     * Pre-order tree traversal begins from argument root,
     * all data from visited Nodes is added to dataList.
     * @param root
     * @param dataList
     */
    private void traversePreOrder(Node<T> root, List<T> dataList) {
        if (root != null) {
            dataList.add(root.getData());
            traversePreOrder(root.getLeft(), dataList);
            traversePreOrder(root.getRight(), dataList);
        }
    }

    /**
     * Post-order tree traversal begins from argument root,
     * all data from visited Nodes is added to dataList.
     * @param root
     * @param dataList
     */
    private void traversePostOrder(Node<T> root, List<T> dataList) {
        if (root != null) {
            traversePostOrder(root.getLeft(), dataList);
            traversePostOrder(root.getRight(), dataList);
            dataList.add(root.getData());
        }
    }
}
