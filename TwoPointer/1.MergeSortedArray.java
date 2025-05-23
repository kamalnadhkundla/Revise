package TwoPointer;

/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Brute force : you can insert the nums2 in all zeroes and re sort the nums1
// optimal : use two pointers instead of coming from starrt lets start filling up the zeroes and we come from back since we need to fill zeroes.
 */
public class 1.MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i =m-1;
        int j =n-1;
        int k =n+m-1;
       System.out.println(i+"-"+j+"--"+k);
       
     while(i>=0 && j>=0){
         if(nums1[i]<nums2[j])
         {
             nums1[k--]=nums2[j--];
            
         }else
           {
             nums1[k--]=nums1[i--];
           }
     }
    
    

     //merge remaining
      while (j >= 0) {
         nums1[k] = nums2[j--];
         k--;
     }
     
 }
    
}
