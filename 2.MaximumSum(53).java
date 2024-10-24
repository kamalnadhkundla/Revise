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
 }/// if you observem we alter the current sum only if it does not add up the value i mean there is no significance in it.,
 // so we alter it to the new sum starting with the current element.

 // case 2 : if all elements are postive or negative , you know that sum of all the positive elements of an arrays gives the maxsum, 
 // where as minimum number of that array consists of negative elements gives the maxsum in the negative elements.

 // varaition of circular subarray : LC 918
 /*
  * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 

Constraints:

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
  */
// Idea : forget about the case where all the elements are positive or negative, consider the case where the array consists of both positive and negative
// you know circular subarray is adding the last subarray and index starting with 0, but we need to maxsum here if index 0 is a -ve , dont need to add it.
//[-one+ve---minsum----maxsum] 
//-----------total------------         -> this give me a intuition removing total-minsum = maxsum+(one+ve ele) Note: there may be 1 or more than postive starting with 0 index.
class Solution2 {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==1) return nums[0];
        int maxsum=Integer.MIN_VALUE;
        int minsum=Integer.MAX_VALUE;
        int cursum=nums[0];
        int curmin=nums[0];
        for(int i =1;i<nums.length;i++){
            cursum=Math.max(cursum+nums[i],nums[i]);
            maxsum=Math.max(cursum,maxsum);
            curmin=Math.min(curmin+nums[i],nums[i]);
            minsum=Math.min(curmin,minsum);
            System.out.println(minsum +" max"+maxsum);
        }
        int total=0;
        for(int i =0;i<nums.length;i++)
         total+=nums[i];
 System.out.println(minsum +" max"+maxsum+"tot"+total+"toa"+(total-minsum));

 if(total-minsum<=0) return maxsum; // if that is less than 0,you can directly return the maxsum right because that does not add a value.
//  //if array is postive

//  boolean check = true;
//  for(int i =0;i<nums.length;i++){
//     if(nums[i]<0) check=false;
//  }

//  // if array is negative
//  boolean check1 =true;
//  for(int i =0;i<nums.length;i++){
//     if(nums[i]>0) check1=false;
//  }
// if(check==true) return total;
// else if (check1==true) return maxsum;

         return Math.max(maxsum, total-minsum);
    }
}