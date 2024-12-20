/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

 */
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
       ArrayList<Integer> arr = new ArrayList<>(); 
       int firstrow=0;
        int lastrow=matrix.length-1;
        int firstcol=0;
        int lastcol=matrix[0].length-1;
        int x =matrix.length*matrix[0].length;
       while(arr.size()<x){
           
           for(int i =firstrow;i<=lastcol &&arr.size()<x;i++){
               
               arr.add(matrix[firstrow][i]);
           }
           firstrow++;
           for(int i =firstrow;i<=lastrow &&arr.size()<x;i++)
           {
               
               arr.add(matrix[i][lastcol]);
           }
           lastcol--;
           for(int i =lastcol;i>=firstcol&&arr.size()<x;i--){
               
               arr.add(matrix[lastrow][i]);
           }
           lastrow--;
           
           
           for(int i =lastrow;i>=firstrow&&arr.size()<x;i--){
               
               arr.add(matrix[i][firstcol]);
           }
           firstcol++;
       }
        
        
        return arr;
    }
}