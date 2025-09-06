package GRAPHS.shortestpath;

import java.util.*;

class BellmanFordExample {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            src = s; dest = d; wt = w;
        }
    }

    public static void bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.wt;
                }
            }
        }

        // Check for negative cycles
        for (Edge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]) {
                System.out.println("Graph contains a negative cycle!");
                return;
            }
        }

        // Print results
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " → " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 4; // number of vertices
        List<Edge> edges = new ArrayList<>();

        // Graph: A=0, B=1, C=2, D=3
        edges.add(new Edge(0, 1, 1));   // A→B (1)
        edges.add(new Edge(1, 2, 1));   // B→C (1)
        edges.add(new Edge(2, 3, 1));   // C→D (1)
        edges.add(new Edge(0, 3, 10));  // A→D (10)

        bellmanFord(V, edges, 0);
    }
}
