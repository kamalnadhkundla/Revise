package Greedy.Intervals;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105


Basic intituion : left, overlap, restofthe interval : and most important there may be a overlap or not be a overlap
so the second while loops works for both overlap or no overlap if there is overlap it changes the newInterval else add the exisitng newinterval to the resultant
while(i<n && intervals[i][0]<=newInterval[1]) for example  [1,2][3,5][10,12] new interval is [4,8]
then [1,2] will add to my result but  [3,5] i: 5 is less than the 4 so it comes to second loop
while(x<=8) because we are sure that after 8 will be a valid interval they dont overlap
it makes changes into the newinterval, add the newInteval to the result 

if the newinterval is [6,6] the second loop doesnt execute we straight away add newinterval to result/
 */
public class InsertInterval {
    class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       List<int[]> res= new ArrayList<>();

       int i =0;
       int n =intervals.length;
       while(i<n && intervals[i][1]<newInterval[0]){
        res.add(intervals[i]);
      i=i+1;
       }
      while(i<n && intervals[i][0]<=newInterval[1]){
        newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
         newInterval[1] = Math.max(newInterval[1],intervals[i][1]);   //overlaped one
        i++;
      }
      res.add(newInterval);

      while(i<n){
        res.add(intervals[i]);
        i++;
      }
 return res.toArray(new int[res.size()][]);
    }
}
}
