package HEAP;

import java.util.PriorityQueue;

import RECURSION.sumOfFirstN;

public class KthLargestElement {
    public static void largest(int[]arr,int k){
        PriorityQueue<Integer>p=new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            p.add(arr[i]);
        }for(int i=k;i<arr.length;i++){
            if(p.peek()<arr[i]){
                p.remove();
                p.add(arr[i]);
            }
        }System.out.println(p.peek());
    }public static void main(String[] args) {
        int[]arr={6,8,2,10,5,7,4,3};
        largest(arr, 3);
    }
}
