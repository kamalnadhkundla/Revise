package GRAPHS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * wordladder 1
 * 
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
 */

public class wordladder {
   static class pair{
        String s;
        int level;
        pair(String s, int level){
            this.s=s;
            this.level=level;
        }
    }
      public  static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words= new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            words.add(wordList.get(i));
            
        }
        Queue<pair> que= new LinkedList<>();
        que.add(new pair(beginWord, 1));
        if(words.contains(beginWord)) words.remove(beginWord);

        while(!que.isEmpty()){
            pair p=que.poll();
            if (p.s.equals(endWord)){
                System.out.println(endWord);
                return p.level;
            }
            for(int i=0;i<p.s.length();i++){

               
                for(char ch ='a'; ch<='z';ch++){
                    String temp = p.s.substring(0, i) + ch + p.s.substring(i + 1);

                   if(words.contains(temp)) {
                        que.add(new pair(temp,p.level+1 ));
                        words.remove(temp);
                   }
                }
            }

        }
                return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
       String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
       System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));
        
    }
    
}
