package HEAP;

import java.util.Collections;
import java.util.PriorityQueue;

public class ProfitMaximisation {
    public static void maximization(int ticket,int[]arr){
        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            p.add(arr[i]);
        }int profit=0;
        for(int i=0;i<ticket;i++){
            int first=p.remove();
            profit+=first;
            p.add(first-1);
        }System.out.println(profit);
    }public static void main(String[] args) {
        int[]arr={6,4,2,3};
        maximization(5, arr);
    }
}
