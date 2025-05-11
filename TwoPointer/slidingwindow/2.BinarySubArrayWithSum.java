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
why this formulae  calculatesubarrays(nums,goal)-calculatesubarrays(nums,goal-1);
because if you are unsure about getting all the valid segments between left and right you use this triclk
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
        


            // hashbased solution
            public int numSubarraysWithSum(int[] nums, int goal) {
                Map<Integer,Integer> map= new HashMap<>();
                int count=0;
                int sum=0;
                        map.put(0,1);
                
                for(int i : nums){ sum+=i;
                
                if(map.containsKey(sum-goal)) count+=map.get(sum-goal);
                
                map.put(sum,map.getOrDefault(sum,0)+1);
                
                }
                
                return count;
    
}

/*
 * count of nice subarrays works in the sameway
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16

sliding window solution: 
public int numberOfSubarrays(int[] nums, int k) {
        
    return calculatesubarrays(nums,k)-calculatesubarrays(nums,k-1);
        
    }
    public int calculatesubarrays(int[] nums, int sum){
        if(sum<0) return 0;

        int left=0;
        int csum=0;
        int count=0;
        for(int right =0;right<nums.length;right++){
            if(nums[right]%2!=0)
               csum+=1;
            while(csum>sum && left<nums.length) {
                if(nums[left]%2!=0)
                   csum-=1;
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }

    a small change to hashbased prefix sum why dont you convert it into  binary subarray if even 0 if odd 1 then using prefix sum that equal to k odd will give the answer
     int numberOfSubarrays(vector<int>& nums, int k) {
        for(int i = 0; i < nums.size(); i++) {
            nums[i] %= 2;
        }
        
        vector<int> prefixCounnt(nums.size() + 1);
        prefixCounnt[0] = 1;
        int s = 0, ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            s += nums[i];
            ans += (s >= k) ? prefixCounnt[s - k] : 0;
            prefixCounnt[s]++;
        }
        return ans;
 */