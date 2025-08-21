package GRAPHS;

import java.util.ArrayList;
/*
 * unlike undirected graph here you need to check whether the particular nodes exisits in my path or not.
 */
public class detectCycleDirectdGraph {

    public static boolean checkCycle( ArrayList<ArrayList<Integer>> adj, int V){
     
        int[] visited= new int[V];
        int[] path= new int[V];

        for(int i=0;i<V;i++){
            if(visited[i]!=1)
              if( dfs(i,visited,path,adj)) return true;
        }

        return false;

    }
    public static boolean dfs(int sourceNode, int[] visited, int[] path,ArrayList<ArrayList<Integer>> adj){
        if(path[sourceNode]==1) return true;
        if(visited[sourceNode]==1) return false;

        visited[sourceNode]=1;

      

        path[sourceNode]=1;

        for(int i=0;i<adj.get(sourceNode).size();i++){
            if(dfs(adj.get(sourceNode).get(i), visited, path, adj)) return true;
        }
        path[sourceNode]=0;

        return false;
        
    }

    public static void main(String[] args) {
       int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

      
        System.out.println(  checkCycle(adj, V));

    }
    
}
