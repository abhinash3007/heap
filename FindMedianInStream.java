package HEAP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void add(int num) {
        if (max.isEmpty() || num < max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }
        if (max.size() > min.size() + 1) {
            min.add(max.peek());
            max.remove();
        } else if (max.size() < min.size()) {
            max.add(min.peek());
            min.remove();
        }
    }

    public double median2Optimal() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek())/2;
        } else {
            return (max.peek());
        }
    }

    public static void median2(int[] arr) {
        FindMedianInStream stream = new FindMedianInStream();
        for (int num : arr) {
            stream.add(num);
            System.out.println(stream.median2Optimal());
        }
    }

    public static void median(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            Collections.sort(list);
            if (list.size() % 2 != 0) {
                System.out.println(list.get(list.size() / 2));
            } else {
                System.out.println((list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 11, 4, 9, 15, 2, 1, 18 };
        median(arr);
        median2(arr);
    }
}
