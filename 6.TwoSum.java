/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Approach : Hashing 
        
 */

import java.util.HashMap;

class TwoSum {

    public int[] solve(int[] nums, int target){
        Map<Integer,Integer>map=new HashMap<Integer, Integer>();
        

        for(int i =0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                 return new int[]{map.get(target-nums[i]),i};
            else
                 map.put(nums[i],i);

        }

        return new int[]{0,0};
    }
    
}
/* Another variant but this time a triplet
 THREE SUM
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Approach 1 : Hashing
 * 
 * 
 */
class solutionHashing{
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> set = new HashSet<>(); // To store unique triplets

        // Outer loop for first element selection
        for (int i = 0; i < nums.length - 2; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            // Inner loop to find pairs
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int diff = 0 - sum;

                // Check if the complement exists
                if (map.containsKey(diff)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], diff);
                    Collections.sort(triplet); // Ensure sorted order for uniqueness
                    set.add(triplet); // Add to set to avoid duplicates
                } else {
                    map.put(nums[j], j); // Store the current number in the map
                }
            }
        }

        // Convert set to list before returning
        return new ArrayList<>(set);
    }
}

/*
 * Approach : Two Pointer technique ,
 * first sort the array
 * keep i and j and k at the last index , check if they are equal to 0 if equal add them into the list, if not?
 * if not, check the bound if the sum is away from the target decrease the k and increase j if the near. to avoid duplicates make sure you ignore the duplicates.
 * both the approach has the same time complexity to reduce the extra space complexity of hashmap we use this solution.
 */
class solutionTwoPointer{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

       
        int n=nums.length;
       for(int i =0;i<n;i++){
            
            if(i>0  && nums[i]==nums[i-1]) continue;
          
            int j =i+1;
            int k =n-1;
          
            while(j<k){
              int sum = nums[i]+nums[j]+nums[k];
            if(sum==0){
                ArrayList<Integer> temp = new ArrayList<>();
                System.out.println("hi");
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[k]);
                list.add(temp);
                 j++;
                 k--;

                while(j<k && nums[j]==nums[j-1] ) j++;
                while(k>0 && nums[j]==nums[k+1]) k--;
            }
            else if(sum>0){
               k--;
            }
            else
               {
                j++;
               }
            
        }
       }

        return list;
    
}}


/*
 * Another variant - 4 Sum 
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */

 /*
  * Better solution again Hashing
  */
  class solution5{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(target==-294967296 ||target == 294967296 || target == -294967297) return result;
               Set<List<Integer>> set = new HashSet<>(); // To avoid duplicates
               int n = nums.length;
       
               // Sorting to avoid duplicate quadruplets and for easier checking
               Arrays.sort(nums);
       
               // Outer loops for the first two elements
               for (int i = 0; i < n - 3; i++) {
                   for (int j = i + 1; j < n - 2; j++) {
                       // Use a HashMap for the remaining pair search
                       HashMap<Integer, Integer> map = new HashMap<>();
       
                       // Search for pairs that sum to target - (nums[i] + nums[j])
                       for (int k = j + 1; k < n; k++) {
                           int requiredSum = target - (nums[i] + nums[j] + nums[k]);
       
                           // If the complement exists in the map, a quadruplet is found
                           if (map.containsKey(requiredSum)) {
                               List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], requiredSum);
                               Collections.sort(quadruplet);  // Ensure sorted order to avoid duplicates
                               set.add(quadruplet);
                           } else {
                               // Add current number to the map
                               map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
                           }
                       }
                   }
               }
       
               // Convert set to list
               result.addAll(set);
               return result;
               
           }
  }