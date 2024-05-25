package HEAP;

public class MaxHeap {
    public static class Heap{
        int[]arr;
        int size;
        int total_size;
        Heap(int n){
            arr=new int[n];
            this.size=0;
            this.total_size=n;
        }
        public void insert(int value){
            if(size==total_size){
                System.out.println("Heap is full");
                return;
            }
            arr[size]=value;
            int index = size;
            size++;
            heapifyUp(index);
        }
        private void heapifyUp(int index) {
            while (index>0) {
                int parent=(index-1)/2;
                if(arr[parent]<arr[index]){
                    swap(parent,index);
                    index=parent;
                }else{
                    break;
                }
            }
        }
        public void delete(){
            if(size==0){
                System.out.println("Heap is empty");
                return;
            }
            System.out.println("Deleted element is: " + arr[0]);
            arr[0]=arr[size-1];
            size--;
            heapifyDown(0);
        }
        public void heapifyDown(int index){
            int leftChild=2*index+1;
            int rightChild=2*index+2;
            int smallest=index;
            if(leftChild<size && arr[leftChild]<arr[index]){
                smallest=leftChild;
            }
            if(rightChild<size && arr[rightChild]<arr[index] && arr[rightChild]<arr[leftChild]){
                smallest=rightChild;
            }
            if(smallest!=index){
                swap(index, smallest);
                heapifyDown(smallest);
            }
        }
        private void swap(int index1, int index2) {
            int temp=arr[index1];
            arr[index1]=arr[index2];
            arr[index2]=temp;
        }
        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
   
    public static void main(String[] args) {
        Heap min=new Heap(6);
        min.insert(5);
        min.insert(8);
        min.insert(7);
        min.insert(1);
        min.insert(3);
        min.insert(15);
        min.printHeap();
        min.delete();
        min.printHeap();
    }
}
