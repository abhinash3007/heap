package HEAP;

import java.util.*;

import javax.swing.tree.TreeNode;

public class BSTtoMaxHeap {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public static void postOrder(Node root, ArrayList<Integer> list, int[] index) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list, index);
        postOrder(root.right, list, index);
        root.data = list.get(index[0]++);
    }

    public static void convertToMaxHeap(Node root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list); // Retrieve nodes in sorted order
        int[] index = { 0 }; // Mutable index for tracking during postOrder
        postOrder(root, list, index);
    }

    public static void level(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node current = q.remove();
            System.out.print(current.data + " ");
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
        System.out.println();
    }

    

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        convertToMaxHeap(root);
        level(root);
    }
}
