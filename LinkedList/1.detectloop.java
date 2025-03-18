public class 1.detectloop {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode Fast=head;
        ListNode Slow = head;
        
        while(Fast.next!=null && Fast.next.next!=null)
        {
            Fast = Fast.next.next;
            Slow = Slow.next;
            if(Fast==Slow) return true;
        }
        return false;
    }
}

// this is tortoise method