package HEAP;

import java.util.ArrayList;

public class MergeTwoMaxHeap {
    public static void merge(int[]arr1,int[]arr2){
        int[]list=new int[arr1.length+arr2.length];
        int i;
        for (i = 0; i < arr1.length; i++) {
            list[i] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            list[i + j] = arr2[j];
        }
        int n = list.length;
        for (int k = n / 2 - 1; k >= 0; k--) {
            heapify(list, n, k);
        }
        for (int l = 0; l < list.length; l++) {
            System.out.println(list[l]);
        }
    }public static void heapify(int[]arr,int n,int index){
        int largest=index;
        int leftChild=2*index+1;
        int rightChild=2*index+2;
        if (leftChild<n && arr[leftChild]>arr[largest]) {
            largest=leftChild;
        }if(rightChild<n && arr[rightChild]>arr[largest]){
            largest=rightChild;
        }if(largest!=index){
            int temp=arr[index];
            arr[index]=arr[largest];
            arr[largest]=temp;
            heapify(arr, n, largest);
        }
    }public static void main(String[] args) {
        int[]arr={10,5,6,2};
        int[]arr2={12,7,9};
        merge(arr, arr2);
    }
}
