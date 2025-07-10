package LIS;

public class Lis {
    // dp[n][n+1]
    
    public int recursiveSolution(int ind, int prevInd){
      
        if(ind==n) return 0;
//if(dp[ind][prevInd]!=-1) return dp[ind][prevInd];
        int option1=0;
        if(arr[ind]>arr[prev] || prev==-1)
           option1=1+recursiveSolution(ind+1, ind);
        int option2 = recursiveSolution(ind+1, prevInd);
        return Math.max(option1, option2);
       // return dp[ind][prevInd]=Math.max(option1,option2);
    }

    public int dpSolution(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int ind = n-1;ind>=0;ind--){
            for(int prevInd=ind-1;prevInd>=-1;prevInd--){
                int option1 = 0;
            if (prevInd == -1 || nums[ind] > nums[prevInd]) {
                option1 = 1 + dp[ind + 1][ind + 1]; // prevInd becomes ind
            }
            int option2 = dp[ind + 1][prevInd + 1]; // skip current element  why prevind+1 cause prevInd might become -1 so we shift by 1.
            dp[ind][prevInd + 1] = Math.max(option1, option2);


            }
           
        }
         return dp[0][0];
        }
    }

    // there comes the main solution
    int mainSolution(int[] nums){
int[] dp = new int[nums.length];
Arrays.fill(dp,-1);
        for(int i =0;i<nums.length;i++){
            for(int p=i-1;p>=0;p--){
                if(nums[i]>nums[p] && 1+dp[p]>dp[i]) dp[i]=1+dp[p];
            
            }
        }
        return Arrays.stream(dp).max().getAsInt();

    }

}
