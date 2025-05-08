/*
 * 
 * Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        // approach : take a map and store the last seen of characters based on last seen we shift our left and right pointers.
        // so for example my left is at char c at 1 index now I encounter a Right at char c on index 5 and my map contains (last seen) (C,1) so lastseenIndex>=left
        // for instance my left is at index 3 that means we dont need to trigger my left, since left has already crossed so we only trigger if it lies in the range.
        // for example left is at 0 last seen at 3 that means  it is in the range that means i have to trigger the left.

        int left=0,right=0;

        int n =s.length();
        Map<Character,Integer> map = new HashMap<>();
      int max=0;
        while(right<n){

            if(map.containsKey(s.charAt(right))){
                if(map.get(s.charAt(right))>=left)
                    left=map.get(s.charAt(right))+1;
               
            }
            max=Math.max(max,right-left+1);
            map.put(s.charAt(right),right);
            right++;
        }

         return max;
    }
   
}