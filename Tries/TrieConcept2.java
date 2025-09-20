package Tries;

import org.w3c.dom.Node;

/*
 * Problem Statement: Implement a Trie data structure that supports the following methods:

Insert (word): To insert a string `word` in the Trie.
Count Words Equal To (word): Return the count of occurrences of the string word in the Trie.
Count Words Starting With (prefix): Return the count of words in the Trie that have the string “prefix” as a prefix.
Erase (word): Delete one occurrence of the string word from the Trie.
 */
public class TrieConcept2 {
     class Node{
      Node[] links = new Node[26];
        int end_word=0;
        int prefix_word=1;

        boolean isContains(char ch){
            return links[ch-'a']!=null;
        }
        void addReference(char ch){
            links[ch-'a']=new Node();
        }
     }

     Node root;
     TrieConcept2(){
        root= new Node();
     }

    public void insert(String word){
Node node=root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.isContains(ch)){
               
                node.addReference(ch);
            }
            
        node= node.links[ch-'a'];
        node.prefix_word+=1;

        }
        node.end_word+=1;
    }
    public boolean searchWord(String word){
        Node node =root;
        for(int i =0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.isContains(ch)) return false;

            node=node.links[ch-'a'];
        }
        return true;
    }
    public int countWordEqualTo(String word){
        Node node= root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.isContains(ch)) return -1;

            node=node.links[ch-'a'];
        }
       return node.end_word;
    }
    public int coundWordstartWith(String word){
        Node node= root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.isContains(ch)) return -1;

            node=node.links[ch-'a'];
        }
       return node.prefix_word;

    }
    public void eraseOccurence(String word){
        Node node= root;
        for(int i =0;i<word.charAt(i);i++){
            if(node.isContains(word.charAt(i))){
                node= node.links[word.charAt(i)-'a'];
                node.prefix_word-=1;;
            }
            else return;
        }
        node.end_word-=1;
    }
}
