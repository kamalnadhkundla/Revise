package Heap.Learning;

public class checkminheapornot {
    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;

        // Only need to check internal nodes (from 0 to n/2 - 1)
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // If left child exists and is smaller than parent
            if (left < n && arr[i] > arr[left]) {
                return false;
            }

            // If right child exists and is smaller than parent
            if (right < n && arr[i] > arr[right]) {
                return false;
            }
        }

        return true;
    }
    
}
