package LinkedList;

public class 4.panlindrome {
    class Solution {
        public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;   
        ListNode fast= head;
        ListNode slow=head;
    
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
    
        }
       ListNode newHead= reverse(slow.next,null);
       ListNode head1=head;
    
       while(newHead!=null){
        if(newHead.val!=head1.val) return false;
    
        newHead= newHead.next;
        head1=head1.next;
    
       }
    
       return true;
    
            
        }
        public ListNode reverse(ListNode current,ListNode prev){
             if (current == null) return prev;
    
            ListNode newtNode = current;
            current=current.next;
            newtNode.next=prev;
            prev=newtNode;
            return reverse(current, prev);
        }
    }
    
}
