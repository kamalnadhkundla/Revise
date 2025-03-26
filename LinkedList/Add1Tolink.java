package LinkedList;

/*
 * You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457

Intution : reverse the linkedlist add1 to starting and start computation checking carry is 1 or not for next node,
at the end reverse the whole array return
or to avaoid 2 passes like reverse initial and after use recurse when we are in the last node we add 1 and back travel.
 */
public class Add1Tolink {
    /*
     * two pass
     */
    class Solution {
        public Node addOne(Node head) {
           Node head1= reverse(head);
           // Add 1 to head1
           int carry=1;
           Node temp = head1;
          Node prev=null;
    
            while (temp != null) {
                int sum = temp.data + carry;
                temp.data = sum % 10;
                carry = sum / 10;
    
                prev = temp;
                temp = temp.next;
            }
    
            // Step 3: If carry still exists, add new node at the end
            if (carry == 1) {
                prev.next = new Node(1);
            }
            Node head2= reverse(head1);
            return head2;
          
        }
        public Node reverse(Node head){
            if(head==null || head.next==null) return head;
            Node prev = null;
    
            while (head != null) {
                Node current = head;
                head = head.next;       // move head ahead
                current.next = prev;    // reverse pointer
                prev = current;         // move prev ahead
            }
    
            return prev; // new head of the reversed list
        }
    }
    // recursion
    class Solution {
        public Node addOne(Node head) {
            int carry = recurse(head);
            
            if (carry == 1) {
                Node newNode = new Node(1);
                newNode.next = head;
                return newNode;
            }
            
            return head;
        }
    
        // Recursive helper method
        int recurse(Node head) {
            if (head == null) return 1; // Base case: add 1 at end
    
            int carry = recurse(head.next);
            int sum = head.data + carry;
            head.data = sum % 10;
            return sum / 10; // return carry to previous node
        }
    }
    
}
