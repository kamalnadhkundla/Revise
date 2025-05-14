package TwoPointer.slidingwindow;

/*
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 
 */

/*
 * There are 2 brute force solutions actually but one brute force will help you build the sliding window approach that runs in linear time complexity.
 * 
 * 1. check the minimum frequency satisified or not by taking 2 hashmaps. if got 2 equal break the loop since we wanted min no need to check further.
 * public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapt = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }

        int minlength = Integer.MAX_VALUE;
        int iIn = -1, jIn = -1; // starting and ending jin can be removed if used iin+minlength;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> maps = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                maps.put(s.charAt(j), maps.getOrDefault(s.charAt(j), 0) + 1);

                if (isequal(mapt, maps)) {
                    if (j - i + 1 < minlength) {
                        minlength = j - i + 1;
                        iIn = i;
                        jIn = j;
                    }
                        break;
                }
            }
        }

        return iIn == -1 ? "" : s.substring(iIn, jIn + 1);
    }

    private boolean isequal(Map<Character, Integer> mapt, Map<Character, Integer> maps) {
        for (char c : mapt.keySet()) {
            if (!maps.containsKey(c) || maps.get(c) < mapt.get(c)) {
                return false;
            }
        }
        return true;
    }
 */

 /*
  * 
  2.  one hashmap is used just check if any char has the preInserted frequency if it is we can say it is existed in string t. then increase the count, if count==t.length check minlength.
   public String minWindow(String s, String t) {
      

      

       int minlength=Integer.MAX_VALUE;
       int startInd=-1;
       
       for(int i =0;i<s.length();i++){
         HashMap<Character,Integer> map = new HashMap<>();
         
          for(char c : t.toCharArray() ){
             map.put(c,map.getOrDefault(c,0)+1);
       }
       int count=0;
        for(int j =i;j<s.length();j++){

           

           if(map.containsKey(s.charAt(j))){
            int preInsertValue=map.get(s.charAt(j));
                if(preInsertValue>0) 
                     count+=1;
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
           }
                
                
            

            if(count==t.length()){
                 if((j-i+1)<minlength) {
                      minlength=j-i+1;
                      startInd=i;
                  }
                break;
            }

        }
       }


       if(startInd==-1)
          return "";
        else
          return s.substring(startInd,startInd+minlength);
        }
  */
// from burteforce you can build a optimal solution, since you got a string that satisifes the condition, may be you can reduce the string from left that satisifes the condition
public class 3.MinimumWindowSubstring {

    public String minWindow(String s, String t) {
      

        HashMap<Character,Integer> map = new HashMap<>();
         
          for(char c : t.toCharArray() ){
             map.put(c,map.getOrDefault(c,0)+1);
       }
       int count=0;

       int minlength=Integer.MAX_VALUE;
       int sInd=-1;
       
       int left=0;
       for(int right =0;right<s.length();right++){

         if(map.containsKey(s.charAt(right)))
         {
           if(map.get(s.charAt(right))>0) count+=1;
           map.put(s.charAt(right),map.get(s.charAt(right))-1);
         }

        while(count==t.length()){
            if(minlength>right-left+1){
                minlength=right-left+1;
                sInd=left;
            }
          if(map.containsKey(s.charAt(left))){
              map.put(s.charAt(left),map.get(s.charAt(left))+1);
            if(map.get(s.charAt(left))>0) count--;
          } 
            left++;
        }
         
        
        
       }


       if(sInd==-1)
          return "";
        else
          return s.substring(sInd,sInd+minlength);
        }
    
}
