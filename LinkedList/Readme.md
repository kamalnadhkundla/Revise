#Patterns in LinkedList
1. Reverese the LinkedList
2. Detect Loop, first detect the loop , if there are other questions like starting point, and length of loop
    - starting point :  from head to starting point is x. and collision point to starting point is same as x. so when collision is detected keep a ptr at head and move the 2 ptrs by 1 each time until they meet at starting point.
3. Check palindrom or not - given a  single linked list, we need to return true if its a palindrome.
                        -pattern : cut it by mid half so we have left half and right half now reverse the right half check each node at a time
                    -Extension : 143. Reorder List,
