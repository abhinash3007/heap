package HEAP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthElementInMatrix {
    public static void kthElementBrute(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[index++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }

    public static void kthBetter(int[][] matrix, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p.size() < k) {
                    p.add(matrix[i][j]);
                } else if (matrix[i][j] < p.peek()) {
                    p.add(matrix[i][j]);
                    p.remove();
                }
            }
        }
        System.out.println(p.peek());
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

    public static void kthOptimal(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < n; i++) {
            pq.add(new Element(matrix[i][0], i, 0));
        }
        for (int j = 0; j < k - 1; j++) {
            Element ele=pq.remove();
            if(ele.col<n-1){
                pq.add(new Element(matrix[ele.row][ele.col+1], ele.row, ele.col+1));
            }
        }System.out.println(pq.peek().data);
    }
    public static void kthBest(int[][]matrix,int k){
        int n=matrix.length;
        int left=matrix[0][0];
        int right=matrix[n-1][n-1];
        while (left<right) {
            int mid=left+(right-left)/2;
            int count=totalCount(matrix,mid);
            if (count<k) {
                left=mid+1;
            }else{
                right=mid;
            }
        }System.out.println(left);
    }public static int totalCount(int[][]matrix,int mid){
        int n=matrix.length;
        int row=n-1;
        int col=0;
        int count=0;
        while (row>=0 && col<=n-1) {
            if (matrix[row][col]<=mid) {
                count+=row+1;
                col++;
            }else{
                row--;
            }
        }return count;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 },
        };
        kthElementBrute(matrix, 8);
        kthBetter(matrix, 2);
        kthOptimal(matrix, 8);
        kthBest(matrix, 8);
    }
}
