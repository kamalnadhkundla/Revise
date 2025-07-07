package LCS;

import java.util.Arrays;

/* 
1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/

public class LCS {
    class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n =text1.length();
        int m =text2.length();
        dp=new int[n][m];
        for(int[] r :dp){
          Arrays.fill(r,-1);
        }
        return recur(n-1,m-1,text1,text2);
        
    }

    public int recur(int ind1, int ind2, String text1, String text2){

        if(ind1<0 ||ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(text1.charAt(ind1)==text2.charAt(ind2)) return 1 + recur(ind1-1,ind2-1,text1,text2);
        else
           return dp[ind1][ind2]= Math.max(recur(ind1-1,ind2,text1,text2),recur(ind1,ind2-1,text1,text2));
    }
}
}
//in case of tabulation, there could be a possiblity that indexs fall into negative index wrt to base case somewe shift index by 1 so the 0 the position lies in 1 position
class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n =text1.length();
        int m =text2.length();
        dp=new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++)
        dp[i][0]=0;
        
        for(int j=0;j<m+1;j++)
             dp[0][j]=0;


        for(int i =1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                 if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                 else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
       
        return dp[n][m];
    }

    public int recur(int ind1, int ind2, String text1, String text2){

        if(ind1<0 ||ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(text1.charAt(ind1)==text2.charAt(ind2)) return 1 + recur(ind1-1,ind2-1,text1,text2);
        else
           return dp[ind1][ind2]= Math.max(recur(ind1-1,ind2,text1,text2),recur(ind1,ind2-1,text1,text2));
    }
}


//printing LCS
I have a dp Arrays

so for(int i=n;i>=0;i--){
    for(int j =dp[i].length-1;j>=0;j--){
        if(text1.charAt(i)==text2.charAt(j)) {
            i-- ; j--;
        }else if(dp[i-1][j]>=dp[i][j-1]) i--;
        else j--;
    }
}