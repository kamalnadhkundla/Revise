package Imp;

/*
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false

 */
// my soluition -> generating every combination for k so the time complexity is k power n
/*
 * class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        int target = sum / k;
        int[] ktharray = new int[k];
 
        return recur(0, nums, ktharray, k, target);
    }

    public boolean recur(int ind, int[] nums, int[] ktharray, int k, int target) {
        if (ind == nums.length) {
            for (int i = 1; i < k; i++) {
                if (ktharray[i] != ktharray[0]) return false;
            }
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (ktharray[i] + nums[ind] > target) continue;

            ktharray[i] += nums[ind];

            if (recur(ind + 1, nums, ktharray, k, target)) return true;

            ktharray[i] -= nums[ind];


        
    }
    return false;
    }
}
 */

 /*
  * in the optimal instead of generating combination for every k first we will generate one then evenutally we fall back we start with a another k we do this until k equal to 0 , since there are 2 choices every step the
  time complexity is 2 power n since we need to find k subsets  it is k* 2 power n
  */

public class Partition to K Equal Sum Subsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        int target = sum / k;
        boolean[] used= new boolean[nums.length];
 
        return recur(0,nums, used, k, 0,target);
    }

    public boolean recur(int start,int[] nums, boolean[] used, int k, int cumsum, int target) {
        if (k == 0) return true;

        if (cumsum == target) {
            return recur(0, nums, used, k - 1,0,  target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i] || cumsum + nums[i] > target) continue;

            used[i] = true;
            if (recur(i+1, nums, used, k, cumsum + nums[i], target)) return true;
            used[i] = false;
        }

        return false;
    }
    
}
