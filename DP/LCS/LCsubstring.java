package LCS;
//this is almost subsequence but not here we need to find the substring that means they are continguous

// so lets take teh tabulation of LCs we are increasing the plus if the character match at some point with the help of previous character right so every time you find max from it.
public class LCsubstring {
    


    public int substring(String text1, String text2){

        int[][] dp = new int[text1.length()+1][text2.length()+1];
int max=0;
        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[i].length;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1)) 
                    {
                        dp[i][j]=1+dp[i-1][j-1];
                        max=Math.max(max,dp[i][j]);
                    }else
                    {
                        dp[i][j]=0; // no subseqquences;
                    }
            }
        }
    }
}
// longest palindrom string

find lcs for string1 and reverse(string1) -> get the answer.