/*
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */





public class 2.Permutation {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
    
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums); // Sort to bring duplicates together
            boolean[] used = new boolean[nums.length];
            backtrack(nums, new ArrayList<>(), used);
            return res;
        }
    
        private void backtrack(int[] nums, List<Integer> path, boolean[] used) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
    
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
    
                // Skip duplicates: only use the first un-used occurrence at each level
                if (i > 0 && nums[i] == nums[i - 1] ) continue;
    
                used[i] = true;
                path.add(nums[i]);
    
                backtrack(nums, path, used);
    
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
    

    
}
