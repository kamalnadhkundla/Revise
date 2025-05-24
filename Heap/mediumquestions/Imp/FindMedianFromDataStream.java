package Heap.mediumquestions.Imp;

import java.util.PriorityQueue;

/*
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 


 */
public class FindMedianFromDataStream {
    class MedianFinder {
PriorityQueue<Integer> smallvalues;
PriorityQueue<Integer> largevalues;
    public MedianFinder() {

      smallvalues= new PriorityQueue<>((a,b)-> b-a); // implement it contains only smaller values but always return a max number
      largevalues= new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {

        
     smallvalues.offer(num);

    // Step 2: Ensure order: max(smallvalues) ≤ min(largevalues)
    if (!largevalues.isEmpty() && smallvalues.peek() > largevalues.peek()) {
        largevalues.offer(smallvalues.poll());
    }

    // Step 3: Rebalance sizes: max difference must be ≤ 1
    if (smallvalues.size() > largevalues.size() + 1) {
        largevalues.offer(smallvalues.poll());
    } else if (largevalues.size() > smallvalues.size() + 1) {
        smallvalues.offer(largevalues.poll());
    }
       

    }
    
    public double findMedian() {
      
      if(smallvalues.size()==largevalues.size()) {
      
        return (double)(smallvalues.peek()+largevalues.peek())/2;
      }
      else if(smallvalues.size()>largevalues.size()){
          
         return (double)smallvalues.peek();
      } 
      else
         return (double)largevalues.peek();

    
}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
    
}
