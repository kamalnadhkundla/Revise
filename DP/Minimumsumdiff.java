/*
 * this problem can be solved using subset sum if they give constrain 0 s1 to allin s2 but here they gave n s1 and n s2 out of 2*n
 * so we use meet in the middle
 * lets think like this : 2*n out of n and n can be taken from left and right 
 * say if the totalsum is x, to get the minimum diff leftsum+rightsum-totalsum>=0
 * but letsay rightsum=totalsum-leftsum gives rightsum
 * so if we know leftsum it is easy to get the rightsum if we get it totalsum-(2(leftsum+rightsum)) gives us the answer since we wanted to have minimum we check all combinations.
 */

public class Minimumsumdiff {
    import java.util.*;

public class Solution {

    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Split the array into two halves
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        // Generate all subset sums grouped by count for left and right halves
        List<List<Integer>> leftSums = generateSubsetSums(left);
        List<List<Integer>> rightSums = generateSubsetSums(right);

        // Sort each list in rightSums for binary search
        for (List<Integer> list : rightSums) {
            Collections.sort(list);
        }

        int minDiff = Integer.MAX_VALUE;

        // For each possible count k of elements chosen from left
        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = leftSums.get(k);
            List<Integer> rightList = rightSums.get(n - k);

            for (int sLeft : leftList) {
                int target = totalSum / 2 - sLeft;

                // Binary search in rightList for closest to target
                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0) {
                    idx = -(idx + 1);
                }

                // Check candidate at idx
                if (idx < rightList.size()) {
                    int sRight = rightList.get(idx);
                    int diff = Math.abs(totalSum - 2 * (sLeft + sRight));
                    minDiff = Math.min(minDiff, diff);
                }

                // Check candidate before idx
                if (idx - 1 >= 0) {
                    int sRight = rightList.get(idx - 1);
                    int diff = Math.abs(totalSum - 2 * (sLeft + sRight));
                    minDiff = Math.min(minDiff, diff);
                }
            }
        }

        return minDiff;
    }

    private List<List<Integer>> generateSubsetSums(int[] arr) {
        int n = arr.length;
        // Create a list for sums of subsets of size 0..n
        List<List<Integer>> sumsByCount = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            sumsByCount.add(new ArrayList<>());
        }

        // Use recursive helper to generate subsets sums
        helper(arr, 0, 0, 0, sumsByCount);

        return sumsByCount;
    }

    private void helper(int[] arr, int index, int count, int currentSum, List<List<Integer>> sumsByCount) {
        if (index == arr.length) {
            sumsByCount.get(count).add(currentSum);
            return;
        }

        // Choose current element
        helper(arr, index + 1, count + 1, currentSum + arr[index], sumsByCount);
        // Skip current element
        helper(arr, index + 1, count, currentSum, sumsByCount);
    }


}
}
