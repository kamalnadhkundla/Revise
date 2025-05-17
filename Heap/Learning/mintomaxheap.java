package Heap.Learning;

public class mintomaxheap {
    public class HeapConverter {

        public static void convertMinToMaxHeap(int[] heap) {
            int n = heap.length;
    
            // Start from last internal node and heapify down
            for (int i = (n / 2) - 1; i >= 0; i--) {
                heapifyDown(heap, n, i);
            }
        }
    
        private static void heapifyDown(int[] heap, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
    
            if (left < n && heap[left] > heap[largest]) largest = left;
            if (right < n && heap[right] > heap[largest]) largest = right;
    
            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                heapifyDown(heap, n, largest);
            }
        }
    
        public static void main(String[] args) {
            int[] minHeap = {1, 3, 5, 7, 9, 6};  // valid min-heap
    
            convertMinToMaxHeap(minHeap);
    
            System.out.println("Converted Max-Heap:");
            for (int val : minHeap) System.out.print(val + " ");
        }
    }
    
    
}
