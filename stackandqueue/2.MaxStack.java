package stackandqueue;

import java.util.Stack;

public class 2.MaxStack {
    

    public class MaxStack{
        Stack<Integer> stack;
       int curmax=0;

        MaxStack(){
            stack=new Stack<>();
}

public int add(int ele){
    if(stack.isEmpty()){
        stack.push(ele);
        curmax=ele;
    }
   else if(!stack.isEmpty() && stack.peek()<ele){
        // ele is bigger than the current max we need to keep track

        stack.push(2*ele-curmax);
        curmax=ele;
}
else
{
  stack.push(ele);
}
    }
    public int top(){
        if(!stack.isEmpty())
        {
            if(stack.peek()>curmax)
                 return curmax;
            else 
               return  stack.peek();
        }
    }
    public int getmax(){
        return curmax;
    }
    public void pop(){
        if(stack.peek()>curmax){
            //this value is updated
            curmax=2*curmax-stack.pop();
        }
        else 
           stack.pop();
    }
    


    }

    public class BruteForce{
        public class pair{
            int x;
            int y;

            pair(int x, int y) {
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
            if(val<p.y)
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
        
        public int getMax() {
            Pair p = stack.peek();
             return p.y; 
        }
    }
 }
    
    

