/*
 * Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

 //  Brute 
 class solution{
    public int maxSubArray(int[] nums) {
        int max=0;



        for(int i =0;i<nums.length;i++){
            int sum=0;
            for(int j =i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>max) max=sum;
            }
        }
        return max;

       
    }


    // KADANE ALGO
    //Kadane's algorithm works by maintaining the running maximum subarray sum (max_current) at each index. 
    //If at any point, the current element alone is larger than the current subarray sum, the algorithm resets the subarray to start from that element.
    // This ensures that you're always keeping track of the highest sum possible as you iterate through the array.





// incase when the give the if the maxsum is less than 0 return 0;

    class solution1{
        public int maxSubArray(int[] nums) {
            int max=0;
    int sum=0;
   
            for(int i =0;i<nums.length;i++){
                sum+=nums[i];
                if(sum>max) max=sum;

                if(sum<0){
                    sum=0;
                }
                
            }
            return max;
    
           
        }
    }
 }
 // incase if the max sum is -1 and so on 
 class solution2{
    public int maxSubArray(int[] nums){
        int max=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++ ){
            sum=Math.max(sum+nums[i],nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
 }/// if you observem we alter the current sum only if it does not add up the value i mean there is no significance in it., so we alter it to the new sum starting with the current element.