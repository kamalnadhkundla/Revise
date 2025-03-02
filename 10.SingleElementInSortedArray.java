
/*
 * Problem Statement: Given an array of N integers. Every number in the array except one appears twice. Find the single number in the array.
 * 
 * Example 1:
Input Format:
 arr[] = {1,1,2,2,3,3,4,5,5,6,6}
Result:
 4
Explanation:
 Only the number 4 appears once in the array.

Example 2:
Input Format:
 arr[] = {1,1,3,5,5}
Result:
 3
Explanation:
 Only the number 3 appears once in the array.

 Think in this sceario, every pair thats on the left hanside start with(even, odd) and every pair on the right hand side start with (odd,even) after that single element.

 * 
 * 
 * 
 * 
 */


public class 10.SingleElementInSortedArray {


    public int singleNonDuplicate(int[] arr) {

        int low=0;
        int high=arr.length-1;
        if(arr.length==1) return arr[0];

        if(arr[0]!=arr[1]) return arr[0];
        if(arr[arr.length-1]!=arr[arr.length -2]) return arr[arr.length-1];

        while (low < high) {
            int mid = (low + high) / 2;

            // Base Case: If `mid` is the single element (avoiding out-of-bounds)
            boolean isUnique = (mid == 0 || arr[mid] != arr[mid - 1]) && 
                               (mid == arr.length - 1 || arr[mid] != arr[mid + 1]);

            if (isUnique) return arr[mid];

            // Check if the left half (low to mid) has an even or odd length
            int leftLength = mid - low + 1;

            if (leftLength % 2 == 0) { // Even length left half
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;  // Move right
                } else {
                    high = mid;  // Move left
                }
            } else { // Odd length left half
                if (arr[mid] == arr[mid - 1]) {
                    high = mid - 2;  // Move left
                } else {
                    low = mid + 1;  // Move right
                }
            }
        }

        return arr[low]; // Return the single element when `low == high`
    
        
    }
    
}
