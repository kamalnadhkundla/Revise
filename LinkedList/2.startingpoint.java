package LinkedList;

public class 2.startingpoint {
   
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
    
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
    
                if (slow == fast) break;
            }
    
            if (fast == null || fast.next == null) return null;
    
            fast=head;
    
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
    
          
    
            return slow;        
        }
    }
/*
 * 
 * class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        
        Node fast=head;
        Node slow= head;
        
        while(fast!=null && fast.next!=null) {
           fast=fast.next.next;
           slow= slow.next;
           if(fast==slow) break;
           
        }
        if(fast==null || fast.next==null ) return 0;
        slow=slow.next;
        int count=1;
        while(slow!=fast){
            slow=slow.next;
            count++;
        }
        return count;
        
    }
}
 */

