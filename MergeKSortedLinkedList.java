package HEAP;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeList(Node[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        return merge(list, 0, list.length - 1);
    }

    public static Node merge(Node[] list, int start, int end) {
        if (start == end) {
            return list[start];
        }
        int mid = start + (end - start) / 2;
        Node left = merge(list, start, mid);
        Node right = merge(list, mid + 1, end);
        return sort(left, right);
    }

    public static Node sort(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node optimal(Node[] list) {
        PriorityQueue<Node> p = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                p.add(list[i]);
            }
        }
        Node dummy = new Node(0);
        Node curr = dummy;
        while (!p.isEmpty()) {
            Node out = p.poll(); // Poll instead of peek to remove the node from the queue
            curr.next = out;
            curr = curr.next; // Move curr forward
            if (out.next != null) {
                p.add(out.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node[] lists = new Node[3];
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        Node mergedList = mergeList(lists);
        //printList(mergedList);
        Node merged = optimal(lists);
        printList(merged);
    }
}
