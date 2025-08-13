package GRAPHS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

 */
public class Zero_one_Matrix {
static class pair{
    int x;
    int y;
    int distance_of;
    pair(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.distance_of=dist;
    }
}
    public static int[][] updateMatrix(int[][] mat){
      int[][] result = new int[mat.length][mat[0].length];
     Queue<pair> que = new LinkedList<>();
     int[][] visited= new int[mat.length][mat[0].length];
     for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){
            if(mat[i][j]==0){
                que.add(new pair(i,j,0)); visited[i][j]=1;
            }
              
        }
     }
     int[][] dist = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
     while(!que.isEmpty()){
        pair p = que.poll();
        result[p.x][p.y]=p.distance_of;
       
       for(int[] dis : dist){
         if((p.x+dis[0]>=0 && p.x+dis[0]<mat.length) && (p.y+dis[1]>=0 && p.y+dis[1]<mat[0].length) ){
           if(visited[p.x+dis[0]][p.y+dis[1]]==0){
            visited[p.x+dis[0]][p.y+dis[1]]=1;que.add(new pair(p.x+dis[0],p.y+dis[1],p.distance_of+1));
           } 
         }
           
       }
     }
     




      return result;
    }    
    public static void main(String[] args) {
        int[][] mat = {{0,1,1},{1,1,1},{1,1,0}};

     int[][] res=   updateMatrix(mat);
       for(int i=0;i<res.length;i++){
        for(int j=0;j<res[0].length;j++)
           System.out.print(res[i][j]);
        System.out.println();
       }
    }
}
