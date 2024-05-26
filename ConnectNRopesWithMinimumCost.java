package HEAP;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    public static void minimumCost(int[]arr){
        PriorityQueue<Integer>p=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            p.add(arr[i]);
        }int cost=0;
        int ans=0;
        while (p.size()>1) {
            int first=p.remove();
            int second=p.remove();
            ans=first+second;
            cost+=ans;
            p.add(ans);
        }System.out.println(cost);
    }public static void main(String[] args) {
        int[]arr={2,5,4,8,6,9};
        minimumCost(arr);
    }
}
