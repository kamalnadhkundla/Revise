package Tries;

/*
 * Trie Data structure has two main functionalites isSearch(word) search for full word and prefi exists
 */
public class TrieConcept1 {
    Node root;
   public class  Node {

       Node[] links = new Node[26];
       boolean flag=false;
       public boolean isContains(char ch){
        return links[ch-'a']!=null;
       }
       public void addReference( char ch){
        links[ch-'a']=new Node();
       }
       public void setNode(){
        flag=true;
       }
    
   }

   public TrieConcept1(){
    root= new Node();

   }
   public void insertWord(String word){
    Node node=root;
    for(int i =0;i<word.length();i++){
        char ch= word.charAt(i);
        if(!node.isContains(ch))
        {
            node.addReference(ch);
        }
    node = node.links[ch-'a'];
            
   }
   node.setNode();
}
public boolean searchWord(String word){
    Node node=root;

    for(int i=0;i<word.length();i++){
       char ch=word.charAt(i);
       if(!node.isContains(ch)) return false;
       
       node=node.links[ch-'a'];
    }

    return node.flag;

}
public boolean prefixCheck(String word){
    Node node=root;

    for(int i=0;i<word.length();i++){
       char ch=word.charAt(i);
       if(!node.isContains(ch)) return false;
       
       node=node.links[ch-'a'];
    }
return node!=null;

}
// sometimes they might ask search the entire word but with some exceptions like '..a' -> string that ends with a but a  length of 3 . means any character
public boolean searchWord2(String word){
    return dfs(0,root,word);
}
public boolean dfs(int index, Node node, String word){
    if(index==word.length()) return node.flag; // meaning you crossed a string of length 3 so return if there exists an exact length.
    char ch= word.charAt(index);
    if(ch=='.') 
       {
          for(int i=0;i<26;i++)
             if(node.links[i]!=null)
                if(dfs(index+1,node.links[i],word)) return true;
       }else {
           if(!node.isContains(ch)) return false;
           else return dfs(index+1,node.links[ch-'a'],word);
       }

       return false;


}
}