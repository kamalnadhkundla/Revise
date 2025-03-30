/*
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
 

so, if n=1 we have only 0 , if n=2 -> 01 n=3->0110 , n=4->01101001 ... do you see a pattern
                  0
                0   1
            0   1   1 0
        0   1   1 0 1 0 0 1
     1.   if you divide n/2 you will see left half matches n-1 and the other half is a compliment of n-1.
     2. but here we need to get the kth index. if its in left half we can check easily, we go to  n-1 and check it kthposition then return,
     3. what if its in right half, so k should be changed to n-1 index for ex: if k =6, and the mid =4 : k-mid gives us 2 so 2nd index from right half.
     4. but you need to complement right so 1-kthindex(n-1,k-mid) takes up the complement.
     5.Now apply in recursion, first base if n==1 we return 0
     6. think if n=2 and k =2 then mid will be 1 for n=2, then k is more than the mid so k-mid gives us 1 so it is 1st index in the right half
     7. 1-solve(n-1,k-mid) -> now it goes to 1st row , now it automatically return 0 , so the ans  is 1.
     8. in the same way we can break the higher N as well.
 * 
 */

public class kth_symbol_in_grammer{

    public int kthGrammar(int n, int k) {
        return solve(n,k);
       }
   
       public int solve(int n, int k){
           if(n==1 ) return 0;
   
           int mid=(int)(Math.pow(2,n-1))/2;
           if(k<=mid)return solve(n-1,k);
           else return 1-solve(n-1,k-mid);
       }

}