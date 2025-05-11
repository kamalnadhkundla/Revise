package TwoPointer.slidingwindow;

/*
 * 
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

since there are no negative values a hasbased prefixsum and sliding window both work. but consider sliding window it is efficient in space complexity
 */

public class 2.BinarySubArrayWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {


        return calculatesubarrays(nums,goal)-calculatesubarrays(nums,goal-1);
                
            }
            public int calculatesubarrays(int[] nums, int sum){
                if(sum<0) return 0;
        
                int left=0;
                int csum=0;
                int count=0;
                for(int right =0;right<nums.length;right++){
                    csum+=nums[right];
                    while(csum>sum && left<nums.length) {
                        csum-=nums[left];
                        left++;
                    }
                    count+=right-left+1;
                }
                return count;
            }
        
    
}
