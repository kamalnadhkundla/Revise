package Greedy;]


/*
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


this problem can be solved using recursion, but that give TLE. Think in a greedy way at starting index, I have a number, so I can move 1-to -Number right so 
at the index you can have maxindex can reach and traverse 1 to until N check whehter your maxIndex changes from any of that index.

 */

public class 1.Jumpgame {
    class Solution {
        public boolean canJump(int[] nums) {
       boolean canReach = false;
    
       int maxInd=0;
    
       for(int i=0;i<nums.length;i++){
        if(i>maxInd) break;
        if(maxInd>=nums.length-1) {
            canReach = true;
            break;
        }
        if(i+nums[i]>maxInd) 
            maxInd=i+nums[i];
       }
    
       
    return canReach;
            
        }
       
     
    
}

/*
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2  why we should check maxInd after checking globalmax lets say if you have  [9,.... some numbers] length of the array is 6 still we take one jump right
you cant say standing at index 0 i have 9 I dont need any jumps
let it reach saturation point , then if maxInd goes out of the bound then it break the loop
 */
class Solution {
    public int jump(int[] nums) {
int maxInd=0;
    int cnt=0;
        int globalmax=0;
        if(nums.length==1) return 0;
       for(int i=0;i<nums.length-1;i++){
         
       
           if(i+nums[i]>maxInd)  {
               maxInd=i+nums[i];
         
           }
           if(i==globalmax){
          
               globalmax=maxInd;
                cnt++;
            if(maxInd>=nums.length-1) {
           
            break;
        }
              
        }
                 
            
       }
        

        

       
    return cnt;
        
    }
}