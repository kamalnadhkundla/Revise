/*
 * this is simple only based on the recurrence logic pick and non pick.
 * there are similar problems related to it, I will list them all.
 */
Code
Java
class Solution {
    int[][] dp ;
    public int uniquePaths(int m, int n) {
     
           dp = new int[m][n];
           for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    int count=0;
                    if(i>0) count+=dp[i-1][j];
                    if(j>0)count+=dp[i][j-1];
                    dp[i][j]=count;
                }
            }
           }

        
          return dp[m-1][n-1];
    }
    // public int recur(int m, int n, int i, int j){
    //     if(i==m && j==n) return 1;
    //     if(i>m || j>n) return 0;
     
    //      if(i<m && j<n && dp[i][j]!=-1) return dp[i][j];  
       
    //     int count=0;
    //     count+=recur(m,n,i+1,j,visited);
    //     count+=recur(m,n,i,j+1,visited);
       
    //     return dp[i][j]= count;
    // }
}

class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m =obstacleGrid.length;
    int n = obstacleGrid[0].length;
    dp= new int[m][n];
    for(int i =0;i<m;i++){
        for(int j =0;j<n;j++){
            if(i==0 && j==0 && obstacleGrid[i][j]!=1) dp[i][j]=1;
            else if(obstacleGrid[i][j]==1) dp[i][j]=0;
            else{
                
    int count=0;
  if(i>0)  count+=dp[i-1][j];
  if(j>0)  count+=dp[i][j-1];
    dp[i][j]=count;

            }

        }
    }
    return dp[m-1][n-1];
    // for(int[] r : dp)
    //  Arrays.fill(r,-1);
    //   return  recur(m-1,n-1,obstacleGrid);
        
    }
  public int recur(int i, int j, int[][] grid){
      if(i<0 || j<0) return 0;
      if(grid[i][j]==1) return 0;
    if(i==0 && j==0) return 1;
  if(dp[i][j]!=-1) return dp[i][j];
  
    int count=0;
    count+=recur(i-1,j,grid);
    count+=recur(i,j-1,grid);

    return dp[i][j]=count;
  }


}
class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m =grid.length-1;
        int n =grid[0].length-1;
        dp=new int[grid.length][grid[0].length];
     // return minHelper(0,0,grid); 

     for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            if(i==0 && j==0) dp[i][j]=grid[i][j];
            else{
                int up=Integer.MAX_VALUE;
                int down=Integer.MAX_VALUE;
             if(i>0)   up=grid[i][j]+dp[i-1][j];
             if(j>0)   down =grid[i][j]+dp[i][j-1]; 
              dp[i][j]=Math.min(up,down);
            }
        }
     }

      return dp[m][n];
    }
    public int recur(int i, int j , int[][] grid){
        if(i<0 || j<0) return 1000000;
        if(i==0 && j==0) return grid[i][j];
        if (dp[i][j]!=0) return dp[i][j];
      int up=grid[i][j]+recur(i-1,j,grid);
       int down =grid[i][j]+recur(i,j-1,grid);

       return dp[i][j]=Math.min(up,down);
    }
    
}