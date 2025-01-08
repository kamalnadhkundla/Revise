/*
 *  1st variant 
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

routine logic - you will store the frequency of the element and return the element which has the highest frequency.

optimal Approach - Boyre vooting algorithm - think <-----N----> this is the array if one element is appearing more than n/2 that element occurances will be all
over the array, that means we dont need to check the every element of the array so we cancel out take one element at the starting lets think it is the 
element we need to find and starting counting when we see other element we cancel it [1,1,1,2,3] count 1,2,3, when seen count is reduced by 1 count 2 count 1 still 1 is the majority element
one more example [1,1,1,2,2,3,3,3,3,3] count 1,2,3 and then i have seen element 2 count is 2 and then 2 again count is 1 and 3 count is 0 if 
if count is 0, now think the current element is majority element and start counting again now count 1,2,3,4 
 */
public class MajorityElement {

    public int majorityone(int[] nums){
        int majorityelement=0;
        int count=0;
       for(int i =0;i<nums.length;i++){
        if(count==0){
            majorityelement=nums[i];
            count++;
        }
        else if (majorityelement!=nums[i]){
            count--;
        }
        else  count++;
       }

    }
    
}
