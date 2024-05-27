package HEAP;

import java.util.PriorityQueue;

public class KthLargestInStream {
    public static void stream(int[] arr, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (p.size() < k) {
                p.add(arr[i]);
                if (p.size() < k) {
                    System.out.println(-1);
                } else {
                    System.out.println(p.peek());
                }
            } else if (arr[i] > p.peek()) {
                p.remove();
                p.add(arr[i]);
                System.out.println(p.peek());
            } else {
                System.out.println(p.peek());
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 8, 2, 3, 5, 10, 9, 4 };
        stream(arr, 3);
    }
}
