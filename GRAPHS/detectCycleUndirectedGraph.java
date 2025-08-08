package GRAPHS;

import java.util.*;

public class detectCycleUndirectedGraph {

    // Pair to hold (node, parent) during BFS
    static class Pair {
        int node, parent;
        Pair(int node, int parent) { this.node = node; this.parent = parent; }
    }

    // Public API: detects a cycle in an undirected graph (1-indexed)
    public static boolean detectCycle(List<List<Integer>> adj) {
        int n = adj.size() - 1;              // because it's 1-indexed (0 is unused)
        boolean[] visited = new boolean[n + 1];

        for (int start = 1; start <= n; start++) {
            if (!visited[start]) {
                if (bfs(start, adj, visited)) return true;
            }
        }
        return false;
    }

    private static boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        visited[start] = true;                 // mark on enqueue
        q.add(new Pair(start, -1));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int nei : adj.get(cur.node)) {
                if (nei == cur.parent) continue;     // ignore edge back to parent
                if (visited[nei]) return true;       // visited & not parent => cycle
                visited[nei] = true;
                q.add(new Pair(nei, cur.node));
            }
        }
        return false;
    }

    // Demo
    public static void main(String[] args) {
        int N = 7; // highest node index
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>()); // 1-indexed

        // Undirected edges
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 6);
        addEdge(adj, 5, 7);
        addEdge(adj, 6, 7); // creates a cycle: 3-6-7-5-2-1-3

        System.out.println(detectCycle(adj) ? "Cycle exists" : "No cycle detected");
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
