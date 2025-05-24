package Heap.mediumquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.


one approach is to have a PriorityQueue and a map,  and get the minimum number always if min+1 is not available in map return false
else 
  cnt +1 and has a freq more than 1 store them in a templist, after reaching cnt==groupsize put the templist back into the queue then we will get the same minimum
 */
// Optimal use a treemap that works like a hashmap but advantage it is stored in sorted order.
public class HandOfStraights {
    class Solution {
   

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize!=0)
                       return false;

        PriorityQueue<Integer>  queue= new PriorityQueue<>();
        for(int i=0;i< hand.length;i++){
            if(!queue.contains(hand[i]))
                  queue.offer(hand[i] );
        }
        
        int n = hand.length/groupSize;
       Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i< hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

int cnt=0;
ArrayList<Integer> listtemp= new ArrayList<>();
        while(!queue.isEmpty()){
          
             int min=queue.poll();
            cnt++;
           int freq= map.get(min);
           freq=freq-1;
           if(freq==0) map.remove(min);
        else   map.put(min,freq);
           if(cnt<groupSize &&!map.containsKey(min+1)) return false;

           if(freq>0) listtemp.add(min);

           if(cnt==groupSize) {
            queue.addAll(listtemp);
            listtemp.clear();
            cnt=0;
           }

                   

        }
     return true;   
    }
}
    
}


/*
 * class Solution {
   

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize!=0)
                       return false;

       TreeMap<Integer,Integer> map = new TreeMap<>();

       for(int i : hand){
        map.put(i,map.getOrDefault(i,0)+1);
       } 

       while(map.size()>0){
        int x= map.firstKey();
        for(int i =x;i<x+groupSize;i++){
            if(!map.containsKey(i)) return false;
            else
            {
                  int freq= map.get(i);
                  freq=freq-1;
                  if(freq==0) map.remove(i);
                  else
                    map.put(i,freq);
            }
        }
       }
     return true;   
    }
}
 * 
 */