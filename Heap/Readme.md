

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


Do : Task Scheduler



Tree Map Methods :
TreeMap-only Methods (Not in HashMap)
1. ceilingKey(K key)
Returns the smallest key ≥ key, or null if none.

java
Copy
Edit
treeMap.ceilingKey(15);
2. ceilingEntry(K key)
Returns the Map.Entry whose key is the smallest ≥ given key.

java
Copy
Edit
Map.Entry<Integer, String> entry = treeMap.ceilingEntry(15);
3. floorKey(K key)
Returns the largest key ≤ key, or null if none.

java
Copy
Edit
treeMap.floorKey(15);
4. floorEntry(K key)
Returns the Map.Entry whose key is the largest ≤ given key.

java
Copy
Edit
treeMap.floorEntry(15);
5. higherKey(K key)
Returns the next greater key strictly greater than the given key.

java
Copy
Edit
treeMap.higherKey(15);
6. higherEntry(K key)
Returns the Map.Entry with the smallest key strictly > given key.

7. lowerKey(K key)
Returns the next smaller key strictly less than the given key.

java
Copy
Edit
treeMap.lowerKey(15);
8. lowerEntry(K key)
Returns the Map.Entry with the largest key strictly < given key.

9. firstKey() / lastKey()
Get the smallest / largest key.

10. pollFirstEntry() / pollLastEntry()
Removes and returns the entry with the smallest / largest key.

11. subMap(fromKey, toKey)
Returns a view of the portion of the map between two keys.

java
Copy
Edit
treeMap.subMap(10, 20); // keys from 10 to 19
Can also be used with inclusive flags:

java
Copy
Edit
treeMap.subMap(10, true, 20, true);
12. headMap(toKey) / tailMap(fromKey)
Returns all entries with keys less than / greater than or equal to a given key.