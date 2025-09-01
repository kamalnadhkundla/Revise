package GRAPHS.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DAGShortestPath {
    class pair {
        int node, wt;
        pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<pair>> graph= new ArrayList<>();
        for(int i =0;i<V;i++)
           graph.add(new ArrayList<>());

        for(int[] edge: edges){
            int u= edge[0];int v=edge[1];int weight=edge[2];
           graph.get(u).add(new pair(v, weight));

        }
        // toposort
        Stack<Integer> st= new Stack<>();
        int[] visited= new int[V];
        for(int i=0;i<V;i++)
               if(visited[i]==0)
                    dfs(i,st,visited,graph);
     int[] dist= new int[V];
     Arrays.fill(dist,Integer.MAX_VALUE);
     dist[0]=0;
          while (!st.isEmpty()) {
            int u = st.pop();
            if (dist[u] != Integer.MAX_VALUE) {  // skip unreachable nodes
                for (pair p : graph.get(u)) {
                    if (dist[u] + p.wt < dist[p.node]) {
                        dist[p.node] = dist[u] + p.wt;
                    }
                }
            }
        }
     for(int i=0;i<V;i++)
       if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
    return dist;
    }
    public void dfs(int node, Stack<Integer> st, int[] visited, ArrayList<ArrayList<pair>> graph){
      visited[node]=1;
      for(pair neigh : graph.get(node)){
        if(visited[neigh.node]!=1)
            dfs(neigh.node,st,visited,graph);
      }
      st.push(node);
    }