package stackandqueue;
// there are 2 solutions for this 
// brute and optimal
// but brute is not space efficient it take o(2*n) space where o(n) is utilised by the optimal
// In optimal, there is a mathematical formual you should know prior solving this problem.
//  you have array [12,15,14,16,10] upto 16 you have min element of 12 but after reaching 10 the minele
// should be changed right that means you are modifying the min when the currentval < minele right
// if we need to modify it lets perform a mathematical operation so that the previousminval can be restored when we pop 10.
// currentval<minele
// currentval-minele<0
// currentval+currentval-minele<currentval
// 2*currentval-minele<currentval so push it if val<min
// when restoring the previous min => minele=2*currentmin-topvalue
public class 1.Minstack {
    public class optimal{
        class MinStack {
            Stack<Integer> stack;
            int min;
        
            public MinStack() {
                stack = new Stack<>();
                min = Integer.MAX_VALUE;
            }
        
            public void push(int val) {
                if (stack.isEmpty()) {
                    stack.push(val);
                    min = val;
                } else if (val < min) {
                    // encode and update min
                    stack.push(2 * val - min);
                    min = val;
                } else {
                    stack.push(val);
                }
            }
        
            public void pop() {
                if (stack.isEmpty()) return;
        
                int top = stack.peek();
                stack.pop();
                if (top < min) {
                    // decode previous min
                    min = 2 * min - top;
                }
            }
        
            public int top() {
                int top = stack.peek();
                if (top < min) {
                    // it's an encoded value; actual top is current min
                    return min;
                } else {
                    return top;
                }
            }
        
            public int getMin() {
                return min;
            }
        }
    }
    
    public class BruteForce{
        class MinStack {
            Stack<Pair> stack;
           class Pair{
               int x;
               int y;
               Pair(int x, int y){
                   this.x=x;
                   this.y=y;
               }
           }
       
           public MinStack() {
               stack = new Stack<>();
       
               
           }
           
           public void push(int val) {
               if(stack.isEmpty()) stack.push(new Pair(val,val));
       else{
        Pair p = stack.peek();
               if(val>p.y)
                   stack.push(new Pair(val,p.y));
               else
                   stack.push(new Pair(val,val));
       }
              
               
           }
           
           public void pop() {
               stack.pop();
           }
           
           public int top() {
                Pair p = stack.peek();
                return p.x;
           }
           
           public int getMin() {
               Pair p = stack.peek();
                return p.y; 
           }
       }
    }
}
