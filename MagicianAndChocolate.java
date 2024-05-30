package HEAP;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolate {
    public static void maximumChocolate(int time,int[]arr){
        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            p.add(arr[i]);
        }int maxChocolate=0;
        for(int i=0;i<time;i++){
            int first=p.remove();
            maxChocolate+=first;
            p.add(first/2);
        }System.out.println(maxChocolate);
    }public static void main(String[] args) {
        int[]arr={2,4,8,6,10};
        maximumChocolate(5, arr);
    }
}
