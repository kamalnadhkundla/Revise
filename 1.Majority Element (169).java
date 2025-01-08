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
/*
 * optimal Approach - Boyre vooting algorithm - think <-----N----> this is the array if one element is appearing more than n/2 that element occurances will be all
over the array, that means we dont need to check the every element of the array so we cancel out take one element at the starting lets think it is the 
element we need to find and starting counting when we see other element we cancel it [1,1,1,2,3] count 1,2,3, when seen count is reduced by 1 count 2 count 1 still 1 is the majority element
one more example [1,1,1,2,2,3,3,3,3,3] count 1,2,3 and then i have seen element 2 count is 2 and then 2 again count is 1 and 3 count is 0 if 
if count is 0, now think the current element is majority element and start counting again now count 1,2,3,4 
 */
/*
 * 
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


This time we need to find majority element but instead of n/2 think like this if you have an array size of N. lets say the array size is 9 if its 9, how many elements will be more than 3, at most 2 right.
so we will finding at most 2(1 or 2) elements which has most no of occurance that are more than n/3.

same logic but we will utilize one more counter 
 * 
 */

 class Solution3 {
    public int majorityElement(int[] nums) {
   int cnt1=0;
   int ele1=0;
   int cnt2=0;
   int ele2=0;

   for(int i =0;i<nums.length;i++){
    if(cnt1==0 && nums[i]!=ele2){
        cnt1=1;
        ele1=nums[i];
    }
    else if(cnt2==0 && nums[i]!=ele1){
       cnt2=1;
       ele2=nums[i];
    }
    else if(nums[i]==ele1)
        cnt1++;
    else if(nums[i]==ele2)
      cnt2++;
    else {
        cnt1--;
        cnt2--;
    }
   }
return ele1;
        
    }
}
// leet code 
 class Solution4{
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0;
       int ele1=Integer.MIN_VALUE;
       int cnt2=0;
       int ele2=Integer.MIN_VALUE;
    
       ArrayList<Integer> newlist=new ArrayList<>();
    
       for(int i =0;i<nums.length;i++){
        if(cnt1==0 && nums[i]!=ele2){
            cnt1=1;
            ele1=nums[i];
        }
        else if(cnt2==0 && nums[i]!=ele1){
           cnt2=1;
           ele2=nums[i];
        }
        else if(nums[i]==ele1)
            cnt1++;
        else if(nums[i]==ele2)
          cnt2++;
        else {
            cnt1--;
            cnt2--;
        }
       }
        cnt1 = 0; cnt2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == ele1) cnt1++;
                if (nums[i] == ele2) cnt2++;
            }
       if(cnt1>nums.length/3)
             newlist.add(ele1);
        if(cnt2>nums.length/3)
              newlist.add(ele2);
    
    
            
        return newlist;    
        }
    
}