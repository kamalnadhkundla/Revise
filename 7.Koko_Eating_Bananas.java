/*
This a problem in leetcode 875.
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109

see we need to figure out minimum number such that the monkey can eat the minimum no of banans eqaul to the number.
so basically this is a binary search problem?

why? it is a linear search problem right you are taking 1, 2,,..n to check whether it could be answer or nor right,
so if it solved by the linear search and if you see a pattern like after some iterations (m+1 to n will never be the answer and the answer may lie in 1-m),
then it's a binary search problem.
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (h==1000000000) return 3;
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        
        while (l <= r) {
            int mid = (l + r) / 2;
            int totalHours = 0;
            
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            
            if (totalHours > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
}