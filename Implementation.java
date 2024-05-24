package HEAP;

import java.util.*;

public class Implentation {
    public static class MinHeap {
        private ArrayList<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<>();
        }

        private void heapifyUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap.get(parentIndex) > heap.get(index)) {
                    swap(index, parentIndex);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }

        public void insert(int value) {
            heap.add(value);
            heapifyUp(heap.size() - 1);
        }

        public int peek() {
            if (heap.size() == 0) {
                throw new NoSuchElementException("Heap is empty");
            }
            return heap.get(0);
        }

        public int size() {
            return heap.size();
        }

        private void swap(int index1, int index2) {
            int temp = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, temp);
        }

        public static void main(String[] args) {
            MinHeap minHeap = new MinHeap();
            minHeap.insert(10);
            minHeap.insert(5);
            minHeap.insert(30);
            minHeap.insert(2);
            minHeap.insert(8);
            System.out.println("Min element: " + minHeap.peek()); // Should print 2

        }
    }
}
