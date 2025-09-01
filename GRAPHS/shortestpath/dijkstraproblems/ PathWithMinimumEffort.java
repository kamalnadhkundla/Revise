package GRAPHS.shortestpath.dijkstraproblems;

import java.util.Arrays;
import java.util.PriorityQueue;
// this problem can be solved by dijkstra and binary search(max-min)
public class  PathWithMinimumEffort {
    class pair{
        int dist;
        int row;
        int col;
        pair(int dist,int row, int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] distance= new int[heights.length][heights[0].length];
        for(int[] temp:distance) Arrays.fill(temp,Integer.MAX_VALUE);
        distance[0][0]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(0, 0, 0));
        int[][] dir= {{0,-1},{0,+1},{-1,0},{+1,0}};
        while (!pq.isEmpty()) {
          pair p =pq.poll();
           int tempdistance=p.dist;
           int tempx=p.row;
           int tempy= p.col;
           for(int[] d : dir){
            int nx=d[0];
            int ny=d[1];
            if(nx+tempx>=0 && nx+tempx<heights.length && ny+tempy>=0 && ny+tempy<heights[0].length){
                int effort=Math.abs(heights[nx+tempx][ny+tempy]-heights[tempx][tempy]);
                int neweffort=Math.max(tempdistance,effort);
                if(distance[nx+tempx][ny+tempy]>neweffort){
                    distance[nx+tempx][ny+tempy]=neweffort;
                    pq.add(new pair(neweffort,nx+tempx,ny+tempy));
                }
            }
           }          
        }
        return distance[heights.length-1][heights[0].length-1];

    }
}
public int binarysearch(int[][] heights){

    int low=0;
    int high=(int)1e9;
    while(low<=high){
        int mid =(low+high)/2;
        if(ispossible(heights,mid))
        {
            ans = mid;
            high=mid-1;
        }
        else 
          low=mid+1;
    }
}
public boolean ispossible(int[][] hieghts, int k){
    boolean[][] visited= new boolean[hieghts.length][hieghts[0].length];
    int[][] dir= {{0,-1},{0,+1},{-1,0},{+1,0}};
return dfs(heights,visited,0,0,dir,k);
public boolean dfs(int[][] heights,boolean[][] visited,int row, int col, int[][]dir, int k){
        
    if(row<0 || row>=heights.length || col<0 || col>=heights[0].length) return false;
    if(row==heights.length-1 && col==heights[0].length-1) return true;
    visited[row][col]=true;

    for(int[] direction : dir){
        int nx=direction[0];
        int ny=direction[1];
        if(nx+row>=0 && nx+row<heights.length && ny+col>=0 && ny+col<heights[0].length && visited[nx+row][ny+col]!=true && Math.abs(heights[row][col]-heights[nx+row][ny+col])<=k)
         {
            if(dfs(heights,visited,nx+row,ny+col,dir,k)==true) return true;
         }
    }

    return false;
}