package Heap.mediumquestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100
 */

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        // Approach  : store the maxone in the pq, take that particuclar element store it in a queue when the time it is available put it back to pq

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
         Queue<int[]> q = new LinkedList<>();

         int[] freq= new int[26];

         for(char c: tasks)
            freq[c-'A']++;
        
        for(int i  : freq)
            if(i>0)
                pq.offer(i);
        
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
              time+=1;
            if(!pq.isEmpty()){
                 int fre= pq.poll();
                   fre=fre-1;
                 if(fre>0)  q.offer(new int[]{fre,time+n});

            }
            
          
           
            
            if(!q.isEmpty() && time==q.peek()[1]) {
                int[] x=q.poll();
                pq.offer(x[0]);
            }




        }
        return time;


        
    }

    // second one optimal;

        public int leastInterval(char[] tasks, int n) {

      int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

     /*
      *  A A A B B B n=2-> A B Idle A B Idle A B  So if you consider maximum frequency numbers lets say A and B 
         we need to find how many Idle spots can be filled right so A has freq =3 since you do not consider the last one, A will be 2 as the idle spots will be filled in between.
         how many other elements that has the same freq as A, only B right so if n=2 so for every A, you need to have a gap of 2, if B has the same freq
         B will get filled for every A right 
         A _ _ A _ _ A -> A B _ A B _ A -> this means ideally we have one idle spot available between A and the next A.
         how do you find idle spots lets say A has freq 3 since you dont consider last A=2 , then A* n will give us the slots  A _ _ A _ _ A.
         but since you have already found maximum no of ele has the same frequency as A, n will get reduce since A will accompany by those elements for sure.
         n-=(maxcount-1) why -1 ? you are already considering A since n=2 and maxcount=2 maxcount will be 1(only B)
         => n=1 , now A=2 and n=1 we have idle spots available =2;
         how many no of elements are available in the array that are not having the same freq as A , 0 right
         available_elements = tasks.length - (maxfreq*maxcount) -> 6-(3*2)=0
         so we have 2 idle spots availble and there are no elements available to fill the idle spots so idlespots+tasks.length;
         if the idle spots has filled completly then 0+tasks.length (idle+tasks.length)
      */



        int maxFreq = Arrays.stream(freq).max().getAsInt();
        long maxCount = Arrays.stream(freq).filter(f -> f == maxFreq).count();

        int partCount = maxFreq - 1;
        int partLength = n - ((int)maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * (int)maxCount;
        int idleSlots = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idleSlots;

        
    }

    
}
