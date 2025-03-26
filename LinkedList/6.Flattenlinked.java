/*
 * Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom pointer to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and -> represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.

Intituon merge 2 linkedlist but you have multiple linkedlists so go to last one merfg 2 into 1  and backtrack merge again with merged node

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        
        return recurse(root);
      
    }
    Node recurse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        
        Node merged=recurse(head.next);
        
        return merge(merged, head);
    }

   
   Node merge(Node t1, Node t2){
       if(t1==null) return t2;
       if(t2==null) return t1;
       
       Node dummy= new Node(-1);
       Node temp=dummy;
       while(t1!=null && t2!=null){
           if(t1.data<t2.data)
              {
                temp.bottom= t1;
                 temp=t1;
                 t1=t1.bottom;
              }
              else {
                  temp.bottom= t2;
                 temp=t2;
                 t2=t2.bottom;
              }
       }
       while(t1!=null){
           temp.bottom= t1;
                 temp=t1;
                 t1=t1.bottom;
       }
       while(t2!=null){
           temp.bottom= t2;
                 temp=t2;
                 t2=t2.bottom;
       }
       return dummy.bottom;
   }
}
 */