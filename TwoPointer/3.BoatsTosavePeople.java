package TwoPointer;

/*
 * 881. Boats to Save People
Solved
Medium
Topics
Companies
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Approach : sort the array check greedly try the heavies person fits into boat if he is  in calculate the remaining limit of the boat if there is a limit exists why cant we put the lighitest person
 */
public class 3.BoatsTosavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
    int low = 0, high = people.length-1;
    int res=0;
while(low<=high){
    int remain=limit-people[high];
    high-=1;
    res++;
    if(low<=high && people[low]<=remain) low++;

}
return res;

    }
    
}
