package HEAP;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void brute(int[][] arr) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                p.add(arr[i][j]);
            }
        } 
        int[] sort = new int[p.size()];
        int index = 0;
        while (!p.isEmpty()) {
            sort[index++] = p.remove();
        }
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
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

    public static void optimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < n; i++) {
            pq.add(new Element(matrix[i][0], i, 0));
        }while (!pq.isEmpty()) {
            Element ele=pq.remove();
            if(ele.col<m-1){
                pq.add(new Element(matrix[ele.row][ele.col+1], ele.row, ele.col+1));
            }
        }
    }
    public static void main(String[] args) {
        int[][] arrays = {
                { 1, 4, 5 },
                { 1, 3, 4 },
                { 2, 6 }
        };
        brute(arrays);
        optimal(arrays);
    }
}
