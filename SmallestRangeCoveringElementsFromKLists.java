package HEAP;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    public static class Element {
        int data;
        int row;
        int col;

        Element(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int start=0;
        int end=Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if(!nums.get(i).isEmpty()){
                int value=nums.get(i).get(0);
                minHeap.add(new Element(value, i, 0));
                max=Math.max(value, max);
            }
        }
        while (minHeap.size()==nums.size()) {
            Element elem=minHeap.remove();
            min=elem.data;
            if(max-max<end-start){
                start=min;
                end=max;
            }
            int row=elem.row;
            int col=elem.col;
            if(col+1<nums.get(row).size()){
                minHeap.add(new Element(nums.get(row).get(col+1),row,col+1));
                max=Math.max(max, nums.get(row).get(col+1));
                min=minHeap.peek().data;
            }
        }return new int[]{start,end};
    }public static void main(String[] args) {
        List<List<Integer>> nums = List.of(
            List.of(4, 10, 15, 24, 26),
            List.of(0, 9, 12, 20),
            List.of(5, 18, 22, 30)
        );int[]res=smallestRange(nums);
        System.out.println(res[0]+" ,"+res[1]);
    }
}
