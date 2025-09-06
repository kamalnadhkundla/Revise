package GRAPHS.shortestpath;

import java.util.Arrays;

public class FloydWarshall {

   public static void floyfwarshalll(int[][] edges, int nodes){
    int[][] graph= new int[nodes][nodes];
    for(int[]g:graph) Arrays.fill(g,Integer.MAX_VALUE);
    for(int i=0;i<nodes;i++) graph[i][i]=0;
    for(int[] edge:edges){
        graph[edge[0]][edge[1]]=edge[2];
    }
    int[][] dest=new int[nodes][nodes];
    for(int i=0;i<graph.length;i++){
        for(int j=0;j<graph[i].length;j++) dest[i][j]=graph[i][j];
    }

    for(int k=0;k<nodes;k++){
        for(int i=0;i<dest.length;i++){
            for(int j=0;j<dest[i].length;j++){
                dest[i][j]=Math.min(dest[i][j],dest[i][k]+dest[k][i]); // if(dest[i][j]<dest[i][k]+dest[k][j]) dest[i][j]=dest[i][k]+dest[k][j]
            }
        }
    }
    for(int i=0;i<dest.length;i++){
        for(int j=0;j<dest[i].length;j++){
            System.out.print(dest[i][i]);
        } System.out.println();
    }
//  negative cycle 
for(int i=0;i<dest.length;i++){
    if(dest[i][i]<0) System.out.println("negative cycle exists");
}

   }

// cycle 

    public static void main(String[] args){
        int[][] edges= new int[6][3];
        edges[0]= new int[]{0,1,2};
        edges[1]=new int[]{1,2,3};
        edges[2]=new int[]{1,0,1};
        edges[3]=new int[]{3,2,4};
        edges[4]=new int[]{3,0,3};
        edges[5]=new int[]{3,1,5};

        floyfwarshalll(edges,4);
    }
    
}
