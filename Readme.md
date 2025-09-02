#patterns
##Binary search
 1. Direct questions find ceil, find floor, first and last occurence , count of an element(lastocc-first occ)
 2. No of times an array rotated, find an element in rotated sorted array, find an element in nearly sorted array, find an element in infinte sorted array,minimum difference element in sorted array.
 3. Binary search on Answer -pattern , need to make a decision on mid without a key, peak element ,koko eating banana, minimum days to make m boques, capacity to shift package with  D days.
 4. Min max or Max min - basically after finding each min pssiblity i need to find the max element among them or vice versa - so you will use max elements 1 to max and test its possibilty(min) if ok increase max;
 5. Do the Median of 2 sorted Array, an important pattern on Binary Search , kth element of 2 sorted array is an extenison to it
Arrays.binarySearch(arr, key);

🔹 Option 1: Implement Comparable in your Pair class
class Pair implements Comparable<Pair> {
    int dist, node;

    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.dist != other.dist) {
            return this.dist - other.dist;   // primary sort: distance
        }
        return this.node - other.node;       // tie-breaker: node value
    }
}


Then you can use:

PriorityQueue<Pair> pq = new PriorityQueue<>();

🔹 Option 2: Use a custom comparator directly in PriorityQueue
PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> {
        if (a.dist != b.dist) return a.dist - b.dist;  // primary: distance
        return a.node - b.node;                        // secondary: node
    }
);

🔹 Example

Input pairs:

(5, 2), (5, 1), (3, 7), (3, 2)


Order in PQ:

(3, 2), (3, 7), (5, 1), (5, 2)