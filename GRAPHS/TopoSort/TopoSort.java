package GRAPHS.TopoSort;

import java.util.ArrayList;
import java.util.Stack;

/*
 * topodsort is for every edge (u,v) in the linear ordering u always comes before v
 * moreover we can construct toposort only when the graph is Directed Acyclic graph
 * because if it undirected (u,v) then v also comes before u
 * if is cyclic there will be an edge that appears before u
 */


public class TopoSort {

    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> graph, int v){
        int[] visited= new int[v];
        
       Stack<Integer> st = new Stack<>();

        for(int i=0;i<visited.length;i++)
          if(visited[i]!=1)
           dfs(i,graph,st,visited);



        ArrayList<Integer> list= new ArrayList<>();
        while(!st.isEmpty())
           list.add(st.pop());

        return list;
        
    }
    public static void dfs(int sourceNode, ArrayList<ArrayList<Integer>> graph,Stack<Integer> st,int[] visited){


        visited[sourceNode]=1;

        for(Integer i : graph.get(sourceNode))
             if(visited[i]!=1) dfs(i, graph, st, visited);
        st.push(sourceNode);
        return;

    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<v;i++)
            graph.add(new ArrayList<>());
        graph.get(3).add(0);
        graph.get(2).add(0);
        graph.get(1).add(0);
        
        System.out.println(topoSort(graph, v));
    }
    
}
