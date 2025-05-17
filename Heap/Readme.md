

# conversion of minheap to maxheap
Two Main Approaches
✅ Option 1: Rebuild using Heapify
Copy the min-heap array as-is

From the last internal node, run heapifyDown() with max-heap rules

Result is a valid max-heap

✅ Option 2: Insert all elements into a Max-Heap (Priority Queue)
Extract all elements from min-heap

Insert into a new max-heap

Simple and often used in Java/Python

