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
// Reorder list
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow.next, null);
        slow.next = null; // Break the list into two parts

        // Step 3: Merge two halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    public ListNode reverse(ListNode current, ListNode prev) {
        if (current == null) return prev;
        ListNode nextNode = current.next;
        current.next = prev;
        return reverse(nextNode, current);
    }
}

