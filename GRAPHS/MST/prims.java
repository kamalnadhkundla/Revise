package GRAPHS.MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
/*
 * Steps:

Start with any node (say node 0).

Think of this as the “starting tree” with just one node.

Use a priority queue (min-heap) to keep track of all edges leaving the current tree, sorted by their weight (smallest edge first).

Pick the smallest edge from the priority queue.

If it connects to a node that’s not already in the tree, add this edge to the MST.

Add that new node to the tree.

Expand the tree

Look at all edges from the new node to its neighbors.

For each neighbor not already in the tree, push the edge into the priority queue.

Repeat steps 3–4 until all nodes are added to the tree.

At the end, the sum of the chosen edges = MST weight, and the chosen edges themselves = MST structure.
 */

public class prims {
     class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
     }
    public int mst(int[][] edges, int N){
        int[] visited= new int[N];
        List<List<Pair>> graph= new ArrayList<>();
        for(int i=0;i<N;i++)
           graph.add(new ArrayList<>());
        for(int[] edge:edges){
            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        int minsum=0;
        PriorityQueue<int[]> pq= new PriorityQueue<>((int[]a,int[]b)->a[0]-b[0]);
            pq.offer(new int[]{0,0,-1});
            List<int[]>Mstpath= new ArrayList<>();
            while(!pq.isEmpty()){
                int[] temp= pq.poll();
                if(visited[temp[1]]==1) continue;
                minsum+=temp[0];
                visited[temp[1]]=1;
                Mstpath.add(new int[]{temp[1],temp[2]});
                for (Pair nei : graph.get(temp[1])) {
                    if (visited[nei.node]!=1) {
                        pq.offer(new int[]{nei.weight, nei.node,temp[1]});
                    }

            }

    }

    return minsum;
}
    
}
