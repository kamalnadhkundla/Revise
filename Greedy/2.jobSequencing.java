package Greedy;

/*
 * You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
Output: [3, 100]
Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).


You know you will pick the maxones for sure, so have some boolean slots array so that you fill those slots eventually.

 */
public class 2.jobSequencing {

    import java.util.*;

class Solution {

    class Point {
        int deadline;
        int profit;
        Point(int a, int b) {
            this.deadline = a;
            this.profit = b;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int max = 0;
        ArrayList<Point> jobs = new ArrayList<>();

        // Step 1: Store jobs in a list
        for (int i = 0; i < deadline.length; i++) {
            jobs.add(new Point(deadline[i], profit[i]));
        }

        // Step 2: Sort jobs by descending profit
        jobs.sort((a, b) -> b.profit - a.profit);

        // Step 3: Find the maximum deadline
        for (Point job : jobs) {
            max = Math.max(max, job.deadline);
        }

        // Step 4: Create a boolean slot array to track job scheduling
        boolean[] slots = new boolean[max];
        int totalProfit = 0, jobsCompleted = 0;

        // Step 5: Allocate jobs
        for (Point job : jobs) {
            // Try to place job at its latest possible deadline slot
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (!slots[j]) { // If the slot is free
                    slots[j] = true;
                    totalProfit += job.profit;
                    jobsCompleted++;
                    break; // Job placed, move to the next one
                }
            }
        }

        // Step 6: Return results
        return new ArrayList<>(Arrays.asList(jobsCompleted, totalProfit));
    }
}

    
}
