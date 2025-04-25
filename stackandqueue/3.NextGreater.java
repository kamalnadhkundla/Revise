package stackandqueue;

/*
 *   very very important question
 *  next smaller prev smaller prev greater can be built if you know this concept 
 * lets say you have an array you need to find next greater of every element
 * so if you start from 0 how do you know the next element when you dont go through them
 * so start from back, maintain a monotonic stack in a increasing way if the curele is greater than the peek,pop and insert
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public int[] nextgreater(int[] arr){
    Stack<Integer> stack = new Stack<>();
int[] newmat= new int[arr.length];
newmat[newmat.length-1]=-1;
stack.push(newmat[newmat.length-1]);
    for(int i=arr.length-1;i>=0;i--){
        
        while(!stack.isEmpty() && stack.peek()<arr[i])
               stack.pop();
        newmat[i]=stack.peek();


    }
 }

// In the similar way you can build other terms
// let see next smaller

public int[] nextsmaller(int[] arr){
    Stack<Integer> stack = new Stack<>();
    int[] newmat= new int[arr.length];
newmat[newmat.length-1]=-1;
stack.push(newmat[newmat.length-1]);
for(int i=arr.length-1;i>=0;i--){
        
    while(!stack.isEmpty() && stack.peek()>arr[i])
           stack.pop();
    newmat[i]=stack.isEmpty()?-1:stack.peek();


}
return newmat;

}


// There is a question next greater element 2, same one but a minimal change it's circular based array so
// think of an imiginary array residing next to the given array calculate accordingly
// same logic



public int[] nextGreaterElements2(int[] nums) {
    int n = nums.length;
    int[] arr= new int[nums.length];
   Stack<Integer> stack = new Stack<>();
    // circular Array concept with monotonic stack

    for(int i=2*n-1;i>=0;i-- ){
    
       while(!stack.isEmpty() && stack.peek()<=nums[i%n])
            stack.pop();

    if(i<n) arr[i]= stack.isEmpty()?-1:stack.peek();
    stack.push(nums[i%n]);

        
    }
    return arr;

}




