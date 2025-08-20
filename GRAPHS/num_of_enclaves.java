package GRAPHS;

/*
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 */

public class num_of_enclaves {
    
    public static int number(int[][] grid){

        int[][] visited= new int[grid.length][grid[0].length];
        int[][] dir= new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i=0;i<grid.length;i++){
            // first row - last row
          if(grid[0][i]==1)  dfs(0,i,grid,visited,dir);

         if(grid[grid.length-1][i]==1)   dfs(grid.length-1,i,grid, visited,dir);
        }
        for(int i=0;i<grid.length;i++){
            // first col- last col
        if(grid[i][0]==1)    dfs(i,0,grid,visited,dir);

       if(grid[i][grid[0].length-1]==1)     dfs(i,grid[0].length-1,grid,visited,dir);

        }
        int count=0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1) count+=1;
            }
        }
        return count;
    }
    public static void dfs(int x, int y, int[][] grid, int[][] visited, int[][] dir) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == 2 || visited[x][y] == 1 || grid[x][y] == 0) return;

        visited[x][y] = 1;
        grid[x][y] = 2; // Mark as non-enclave

        for (int[] d : dir) {
            dfs(x + d[0], y + d[1], grid, visited, dir);
        }
    }
public static void main(String[] args) {
    int[][] grid= new int[][]{
        {0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}
    };
    System.out.println(number(grid));
}  
}
