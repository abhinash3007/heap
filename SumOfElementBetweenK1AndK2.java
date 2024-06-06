package HEAP;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfElementBetweenK1AndK2 {
    public static void largest(int[] arr, int k, int k2) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            p.add(arr[i]);
        }
        for (int i = 0; i < k2 - 1; i++) {
            p2.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (p.peek() > arr[i]) {
                p.remove();
                p.add(arr[i]);
            }
        }
        for (int i = k2-1; i < arr.length; i++) {
            if (p2.peek() > arr[i]) {
                p2.remove();
                p2.add(arr[i]);
            }
        }
        int sum = 0,sum2 = 0;
        while (!p.isEmpty()) {
            sum += p.peek();
            p.remove();
        }System.out.println(sum);
        while (!p2.isEmpty()) {
            sum2 += p2.peek();
            p2.remove();
        }System.out.println(sum2);
        System.out.println(sum2 - sum);
    }

    public static void main(String[] args) {
        int[] arr = { 20, 8, 22, 4, 12, 10, 14 };
        largest(arr, 3, 6);
    }
}
