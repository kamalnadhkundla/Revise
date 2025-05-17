/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 <= xi, yi <= 104
 * 
 */
// My solution 
class Solution {

    class Point {
        int x, y, distance;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        for (int[] p : points) {
            int dist = calculate(p[0], p[1], 0, 0);
            queue.offer(new Point(p[0], p[1], dist));
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = queue.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;
    }

    public int calculate(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy; // No sqrt needed for comparison
    }
}
// This solution is using minheap and takes o(nlogn) time to insert every coordinate.
// optimal one is using the maxheap that take o(nlogk) time.

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], 
                                      a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }
        return res;
    }
}
/*
 * for (int[] point : points) {
    maxHeap.offer(point);         // O(log k) insert
    if (maxHeap.size() > k) {
        maxHeap.poll();           // O(log k) remove farthest
    }
}
Even though every point is processed, each point is inserted and possibly removed once.

The heap size never grows beyond k

So each offer and poll is O(log k)

 Total Time Complexity:
n insertions, each O(log k)
→ O(n log k) overall

Heap never grows beyond k
→ prevents O(n log n)
 */