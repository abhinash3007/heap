package HEAP;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void smallest(int[]arr,int k){
        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            p.add(arr[i]);
        }for(int i=k;i<arr.length;i++){
            if (arr[i]<p.peek()) {
                p.remove();
                p.add(arr[i]);
            }
        }System.out.println(p.peek());
    }public static void main(String[] args) {
        int[]arr={10,3,7,4,8,9,2,6};
        smallest(arr, 4);
    }
}
