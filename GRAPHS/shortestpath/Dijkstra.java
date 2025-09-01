package GRAPHS.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
// through priority queue 
class Solution {
    class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Pair(v, w));
           
        }

      
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.weight == b.weight ? a.node - b.node : a.weight - b.weight
        );
        pq.offer(new Pair(src, 0));

       
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int nodeDist = p.weight;

           

            for (Pair nei : graph.get(node)) {
                int v = nei.node;
                int wt = nei.weight;
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
/// need to know the shortest path b/w the start and the end.
public List<Integer> getpath(int V, int[][] edges, int src,int dest){

    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
    for(int i =0;i<V;i++){
        graph.add(new ArrayList<>());

    }
    for(int[] edge:edges){
        graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    int[] dist= new int[V];
    int[] parent = new int[V]; Arrays.fill(parent,-1);
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src]=0;
    PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->a.weight-b.weight);
    que.add(new Pair(src, 0));
    while(!que.isEmpty()){
        Pair p = que.poll();
        for(Pair temp : graph.get(p.node)){
            if(dist[temp.node]>p.weight+temp.weight){
                dist[temp.node]=p.weight+temp.weight;
                que.add(new Pair(temp.node,dist[temp.node]));
                parent[temp.node]=p.node;
            }
        }
    }
    List<Integer> result= new ArrayList<>();
    if(dist[dest]==Integer.MAX_VALUE) return result;
 
    while(parent[dest]!=dest){
        result.add(dest);
        dest=parent[dest];
    }
  result.add(src);
    Collections.sort(result);
    return result;

}