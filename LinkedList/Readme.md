#Patterns in LinkedList
1. Reverese the LinkedList
2. Detect Loop, first detect the loop , if there are other questions like starting point, and length of loop
    - starting point :  from head to starting point is x. and collision point to starting point is same as x. so when collision is detected keep a ptr at head and move the 2 ptrs by 1 each time until they meet at starting point.
