package com.netcracker.edu.simplebinarytree;

/**
 * Node for storing data, its left and right children.
 * Implements getters and setters for all fields.
 * @param <T> extends {@code Comparable<T>}
 *
 * @author Danil Lifantev
 */
public class Node<T extends Comparable<T>>{

    private T data;
    // left child
    private Node<T> left;
    // right child
    private Node<T> right;

    /**
     * Default constructor.
     */
    public Node() { }

    /**
     * Constructor specifying Node's data.
     * @param data
     */
    public Node(T data) {
        setData(data);
    }

    /**
     * Constructor specifying Node's data, left and right children.
     * @param data
     * @param left
     * @param right
     */
    public Node(T data, Node<T> left, Node<T> right) {
        this(data);
        setLeft(left);
        setRight(right);
    }

    /**
     * Getter for data.
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for data.
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter for left child.
     * @return
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Setter for left child.
     * @param left
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Getter for right child.
     * @return
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Setter for right child.
     * @param right
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Returns String representation of Node object.
     * @return
     */
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
