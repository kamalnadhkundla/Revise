// Arrays and subarrays:

1. Do you know how many no of ways you can have a subarray inclusion of some number.
   for example [[4, 6, 7, 3, 7, 8]] , from the array return the no of ways you can have the subarrays with inclusion of 3.
   - the index of 3 is 3 in the given array , so (i+1)*(n-i) will give the answer, as no of ways to start including 3 is i+1, and no of ways to end it is n-i
   Ending Point Choices:

You can end anywhere from index 3 up to index 5 (the last index).

Thus, number of possible ending points = 6 - 3 = 3.

(Ending at 3, 4, or 5.)
or you can use this as well, n*(n+1)/2 -> it return all the subarrays so 
formula would be Allthe subarrays- SUbarray that dont include 3
     => All the subarrays - (subarray until index 2) -(subarray after index 3)



2. Count of subarrays having sum==k
   
   use prefix based hashmap

   0 1 2 3 4 5 6
   1,2,3,-3,1,1,1 
   1 3 6 3 4 5 6   -> at ind 6 i got a sum 6 if 6-3(target) gives me sum 3 that means there is a subarray from3 to 6 which is of my target right but how many 3 are available there are 2 so count=2 at that index.

   map.put(0,1);

   for(int i : arr){
    sum+=i;
    
    if(map.contains(sum-target))
         count+=map.get(sum-target)

    map.put(sum,map.getOrDefault(sum,0)+1);

   }