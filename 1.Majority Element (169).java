import java.util.*;
/*Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space? */
 

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
System.out.println(map);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]+" -"+map.get(nums[i]));
           if(Math.ceil(map.get(nums[i]))>(nums.length/2))
                  return nums[i];
            }

            return 0;
        
    }
}


//optimal

class Solution2 {
    public int majorityElement(int[] nums) {
   int cnt=0;
   int ele=0;

   for(int i =0;i<nums.length;i++){
    if(cnt==0){
        cnt=1;
        ele=nums[i];
    }
    else if(ele==nums[i]){
        cnt++;
    }
    else
        cnt--;
   }
int count=0;
   for(int i =0;i<nums.length;i++){
      if(nums[i]==ele) count++;
   }
   if(count>nums.length/2) return ele;
   else return -1;
        
    }
}
//in the optimal solution, I am checking for only one element so I dont need a frequency array to keep track of other elements , any how you know that element exisits more than n/2 times that means n/2+1,2.....
//so let say in an array of size n that elements exists by n/2+1 and other elements by n/2, if we cancel out that element n/2 and the remaning elemenets n/2 we will be left with the extra instances of that elements 1, 2 so if that exists we got the element we can return it.