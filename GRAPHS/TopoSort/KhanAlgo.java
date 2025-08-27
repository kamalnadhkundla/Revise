package GRAPHS.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KhanAlgo {
    public List<Integer> getTopoSort(List<List<Integer>> graph, int V){
        
        int[] visited= new int[V];
        int[] indegree=new int[V];

        for(List<Integer> vertex :graph){
            for(Integer i : vertex)
              indegree[i]++;
        }

       Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < V; i++) {
        if (indegree[i] == 0) {
            q.offer(i);
        }
    }

    List<Integer> result= new ArrayList<>();

    while(!q.isEmpty()){
        int obj = q.poll();
        result.add(obj);
        for(Integer i : graph.get(obj)){
            int cur_indegree=indegree[i];
            cur_indegree-=1;
            indegree[i]=cur_indegree;
            if(cur_indegree==0) q.add(i);
        }
    }

    return result;

    }
    
}
