package GRAPHS.MST.Kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MstKruskal {
    class pair{
        int source;
        int dest;
        int weight;
      pair(int s, int d, int w){
        this.source=s;
        this.dest=d;
        this.weight=w;
      }
    }
    int spanningTree(int V, int[][]edges){
      PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->a.weight-b.weight);
      for(int[] edge:edges){
        pq.add(new pair(edge[0],edge[1],edge[2]));
      }
      int[] rank = new int[V];
      int[] parent= new int[V];
      for(int i =0;i<V;i++) parent[i]=i;
      int minsum=0;
      while(!pq.isEmpty()){
        pair p= pq.poll();
        int s=p.source;
        int d=p.dest;
        int w= p.weight;
        // are you belong to same component,meaning if you belong, I cant take you in the component cause someone has joined you guys with minimum weights in the component.
        if(findParent(s,parent)==findParent(d,parent)) continue;
        else{
            minsum+=w;
            union(rank,parent,s,d);
        }
      }

      return minsum;

    }

    int findParent(int node, int[]parent){
        if(parent[node]==node) return node;
        else return parent[node]=findParent(parent[node],parent);
    }
    void union(int[] rank, int[] parent, int node1,int node2){
        int parent1=findParent(node1, parent);
        int parent2=findParent(node2, parent);
        if (parent1 == parent2) return;
        if(rank[node1]>rank[node2]){
            parent[parent2]=parent1;
        }else if(rank[node1]<rank[node2]){
            parent[parent1]=parent2;
        }
        else{
            parent[parent1]=parent2;
            rank[parent2]++;
        }
    }
}
