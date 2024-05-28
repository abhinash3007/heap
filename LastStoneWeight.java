package HEAP;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void weight(int[]arr){
        PriorityQueue<Integer>p=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            p.add(arr[i]);
        }while (p.size()>1) {
            int first=p.remove();
            int second=p.remove();
            int diff=Math.abs(first-second);
            if(diff!=0){
                p.add(diff); 
            }  
        }System.out.println(p.peek());
    }public static void main(String[] args) {
        int[]arr={2,7,4,1,8,1};
        weight(arr);
    }
}
