package GRAPHS.MST.Kruskal;

public class DisjointSet {

    int[] rank;
    int[] parent;

   public DisjointSet (int n){
    rank= new int[n+1];
    parent=new int[n+1];
    for(int i=0;i<=n;i++)
     parent[i]=i;
   } 
   int findUparent(int node){
    if(node==parent[node]) return node;
    else return parent[node]=findUparent(parent[node]);
   }
   void unionByRank(int node1, int node2) {
    int parent1 = findUparent(node1);
    int parent2 = findUparent(node2);

    if (parent1 == parent2) return; // already in the same set

    if (rank[parent1] > rank[parent2]) {
        parent[parent2] = parent1;
    } else if (rank[parent1] < rank[parent2]) {
        parent[parent1] = parent2;
    } else {
        parent[parent2] = parent1;
        rank[parent1]++;
    }

   }
   void unionBySize(int node1, int node2){
    int parent1 = findUparent(node1);
    int parent2 = findUparent(node2);

    if (parent1 == parent2) return;
    if(size[parent1]>size[parent2]){
        parent[parent2]=parent1;
        size[parent1]+=size[parent2];
    }else{
        parent[parent1]=parent2;
        size[parent2]+=size[parent1];
    }
   }

}
