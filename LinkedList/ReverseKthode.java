package LinkedList;

/*
 * 
 * 25. Reverse Nodes in k-Group
Solved
Hard
Topics
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
intituion extract the sub linkedlist of k group reverse and attach
 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ReverseKthode {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode newHead= null;
        ListNode prev=null;
        ListNode next=null;

        while(temp!=null){
            ListNode kthnode= getkthnode(temp,k);
            if(kthnode==null){
                prev.next=temp;
                break;

            }
            next=kthnode.next;
            kthnode.next=null;
            
            ListNode node=reverse(temp);
            if(newHead==null){
                newHead= node;
            }else{
                prev.next=node;
            }
            prev=temp;
            temp=next;
            
        }
        return newHead;
    }
    public ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode current= node;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        return prev;
    }
    public ListNode getkthnode(ListNode head, int k ){
        ListNode temp=head;
        int ct=1;
        while(temp!=null && ct!=k){
            temp=temp.next;
            ct++;
        }
        return temp;
    }}
    
}
