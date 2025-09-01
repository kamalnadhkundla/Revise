package GRAPHS.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class shortestPathinUndirectedGraph {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) { // 
         Queue<Integer> que = new LinkedList<>(); que.add(src); 
         int[]dist=new int[adj.size()];
          Arrays.fill(dist,Integer.MAX_VALUE);dist[src]=0; 
          while(!que.isEmpty()){ 
            int p = que.poll(); 
            for(int neigh : adj.get(p)){
                 if(dist[neigh]>dist[p]+1) { 
                    dist[neigh]=dist[p]+1; 
                    que.add(neigh); 
                } } } 
                    int[] res= new int[dist.length]; 
                    Arrays.fill(res,-1);
                     for(int i=0;i<res.length;i++) 
                     if(dist[i]!=Integer.MAX_VALUE)
                      res[i]=dist[i]; 
        return res;
     }
}
