package TwoPointer;
/*
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Input s="deeee"
output: true

brute : check element bby element whether deletion of that element can make the string palindrome or not
 * 
 * 
 *   public boolean validPalindrome(String s) {
        int n = s.length();
        
        // If the original string is already a palindrome
       // if (check(s)) return true;

        // Try removing one character at each position and check
        for (int i = 0; i < n; i++) {
            String modified = s.substring(0, i) + s.substring(i + 1, n);
            if (check(modified)) return true;
        }

        return false;
    }

    // Helper method to check if a string is a palindrome
    public boolean check(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }

        return true;
    }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
//optimal : cancel out the matching character like a....a and check for the middle string, now in middle string you have b at the start and a at the end 
// check removal of d can make the string palindrome or removal of a can make the string palindrome
public class 2.validPalindrome {

    public boolean validPalindrome(String s) {
        int n = s.length();
        
       
       int low=0;
       int high=n-1;
       while(low<=high){
        if(s.charAt(low)==s.charAt(high)){
            low++;
            high--;
        }
        else {
            String modified1= s.substring(low+1,high+1);
            String modified2=s.substring(low,high);
            if(check(modified1)|| check(modified2)) return true;
            else
               return false;

        }
       }
        return true;
    }

    // Helper method to check if a string is a palindrome
    public boolean check(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }

        return true;
    }

    
}
