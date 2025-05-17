package Heap.Learning;
import java.util.*;
public class MinHeapImplementation {

    ArrayList<Integer> heap;

    private MinHeapImplementation(){
        this.heap = new ArrayList<>();
    }

    private int getParent(int i) { return (i - 1) / 2; }
    private int getLeftChild(int i) { return 2 * i + 1; }
    private int getRightChild(int i) { return 2 * i + 2; }

    public void insert(int val){
        heap.add(val);
        heapup(heap.size()-1);
    }
    public int peek(){
        return heap.get(0);
    }

    public int remove(){
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);

        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapDown(0);
        }

        return min;
    }

    public void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);

    }

    public void heapup(int i){

        while (i > 0 && heap.get(i) < heap.get(getParent(i))) {
            swap(i, getParent(i));
            i = getParent(i);
        }
    }
    public void heapDown(int i){

        int smallest = i;
        int left = getLeftChild(i);
        int right = getRightChild(i);

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapDown(smallest);
        }
    }
    public void printHeap() {
        System.out.println(heap);
    }

   

    
}
