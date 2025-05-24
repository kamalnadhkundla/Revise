package Heap.mediumquestions.Imp;

import java.util.PriorityQueue;

/*
 * A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.
 
 */
public class LongestHappyString {
    
    class Solution {

    class Point {
        char c;
        int freq;

        Point(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);

        if (a > 0) pq.offer(new Point('a', a));
        if (b > 0) pq.offer(new Point('b', b));
        if (c > 0) pq.offer(new Point('c', c));

        StringBuilder str = new StringBuilder();

        while (!pq.isEmpty()) {
            Point first = pq.poll();

            int len = str.length();
            if (len >= 2 && str.charAt(len - 1) == first.c && str.charAt(len - 2) == first.c) {
                if (pq.isEmpty()) break;
                Point second = pq.poll();

                str.append(second.c);
                second.freq--;
                if (second.freq > 0) pq.offer(second);
                pq.offer(first);
            } else {
                str.append(first.c);
                first.freq--;
                if (first.freq > 0) pq.offer(first);
            }
        }

        return str.toString();
    }
}

}
