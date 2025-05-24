package Heap.mediumquestions.Imp;

import java.util.PriorityQueue;

/*
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */
//my approach
/*
 * class Solution {

    class point{
        char c;
        int freq;
        point(char c, int freq){
            this.c=c;
            this.freq=freq;
        }
    }
    public String reorganizeString(String s) {
       Map<Character, Integer> map = new HashMap<>();
      
      PriorityQueue<point> pq= new PriorityQueue<>(
       (point a , point b)-> b.freq-a.freq
      );

       for(char c:s.toCharArray()){

        map.put(c,map.getOrDefault(c,0)+1);
        if(map.get(c)>(s.length()+1)/2) return "";
       }
       
       for( char c : map.keySet()){
          pq.offer(new point(c,map.get(c)));
       }
        Queue<point> queue= new LinkedList<>();
        boolean shift = false;
       StringBuilder str= new StringBuilder();
        while(!pq.isEmpty() || !queue.isEmpty()){

            if(!pq.isEmpty()){
                point p = pq.poll();
                p.freq=p.freq-1;
                str.append(p.c);
                if(p.freq>0) queue.offer(p);

            } 

            if(shift==false) {
                shift=true;
                continue;
            }else
            {
                if(!queue.isEmpty()){
                    while(!queue.isEmpty())
                       pq.offer(queue.poll());
                }
                shift=false;
            }
          
        }
        return str.toString();
    }
}
 */

public class ReorganizeString {
    

    public class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty() || prev != null) {
            if (prev != null && maxHeap.isEmpty()) {
                return "";
            }

            int[] curr = maxHeap.poll();
            res.append((char) (curr[1] + 'a'));
            curr[0]--;

            if (prev != null) {
                maxHeap.offer(prev);
                prev = null;
            }

            if (curr[0] > 0) {
                prev = curr;
            }
        }

        return res.toString();
    }
}
}
