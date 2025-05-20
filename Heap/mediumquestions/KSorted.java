package Heap.mediumquestions;

import java.util.PriorityQueue;

/*
 * Given an array arr[], where each element is at most k away from its target position, you need to sort the array optimally.
Note: You need to change the given array arr[] in place.

Examples:

Input: arr[] = [6, 5, 3, 2, 8, 10, 9], k = 3
Output: [2, 3, 5, 6, 8, 9, 10]
Explanation: The sorted array will be 2 3 5 6 8 9 10
Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: The sorted array will be 1 2 3 4 5 6 7 8 9 10
Don't use the inbuilt sort() function for this question.
 */
// the simple solution you think is sort the array using Arrays.sort() that take o(nlogn)
// if the question was given without k, we would have done it using Arrays.sort() 
// but the question strictly said every element in the given array is placed k positions away from the orginal sorted array
// that means i i select an element at index 0 I dont know which one to compare with so eveuntually I look at all the elements in array whether it is smallest or not, to get it placed at undex 0
// but given that at index 0, the original element of that can be  found from 0 to atmost k indices so do you need to look at all the indices?
// No, you look at 0 to k indices if you  found a minimum among them you place it at 0 th index, same goes for every index.
// this can be solved via priorityqueue.

public class KSorted {

     public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        
        for(int i =0;i<=k;i++)
           queue.offer(arr[i]);
           
           int index=0;
           for(int i =k+1;i<arr.length;i++){
               arr[index++] = queue.poll();
               queue.offer(arr[i]);
               
           }
           while(!queue.isEmpty()){
                arr[index++] = queue.poll();
           }
           
          
    }
}
    
