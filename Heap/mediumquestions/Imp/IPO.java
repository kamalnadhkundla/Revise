package Heap.mediumquestions.Imp;
/*
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

 

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Example 2:

Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
Output: 6
 

Constraints:

1 <= k <= 105
0 <= w <= 109
n == profits.length
n == capital.length
1 <= n <= 105
0 <= profits[i] <= 104
0 <= capital[i] <= 109
 */

import java.util.PriorityQueue;

public class IPO {

    class Solution {
    class Project {
        int capital, profit;
        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    // public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    //     PriorityQueue<Project> pq = new PriorityQueue<>((a, b) -> {
    //         if (a.capital == b.capital) return b.profit - a.profit;
    //         return a.capital - b.capital;
    //     });

    //     // Add all projects to the heap
    //     for (int i = 0; i < profits.length; i++) {
    //         pq.offer(new Project(capital[i], profits[i]));
    //     }

    //    for(int i =0;i<k;i++){
    //     if(!pq.isEmpty() &&
    //         pq.peek().capital<=w){
    //        w+=pq.poll().profit;
    //     }else
    //        break;
    //    }
    //    return w;

       // the above code do not work because you have a available tasks, you always pick the first one from it under your capital lets say k=1, and w=2 profits=[1,2,3] and capital =[1.1.2] you have only one change to pick the best
       /*
       so According to the code, you will sort them using a priority queue in such a way that [1,2][1,1][2,3] you have w=2 initially you could have picked [2,3] but you pick [1,2] so this doesnt work. lets say We have 2 priorityqueues, 
       in first pq lets say we store all available tasks, and then in another one we poll from first pq and store them , so that we will get the best one out.
    }
    */
public int findMaximizedCapital(int k, int w, int[] profits, int[] capital){

 PriorityQueue<Project> pq = new PriorityQueue<>((a, b) -> {
            
            return a.capital - b.capital;
        });
    PriorityQueue<Project> secpq= new PriorityQueue<>((a,b)->  b.profit-a.profit);

  for(int i =0;i<profits.length;i++){
    pq.offer(new Project(capital[i],profits[i]));
  }

  for(int i =0;i<k;i++){
  
     while(!pq.isEmpty() && pq.peek().capital<=w){
        secpq.offer(pq.poll());
     }

     if(secpq.isEmpty()) break;

     w+=secpq.poll().profit;

  }

return w;
}

}

    
}
