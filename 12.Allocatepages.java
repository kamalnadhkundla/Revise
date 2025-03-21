/* when ever you see a problem that is min max or max min it is a binary search problem
 * I was given a array of pages, so the i'th book does contain arr[i] pages and a number k (students) , so i need to allocate all these pages to these students such that:
 * Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
  Finally I have allocate a maximum number of pages assigned to a student is minimum
  for example if the array pages like [12,15,10,9] and no of student is 3 what could be the maximum number here in one possibility [12,15] can be assigned to 1 student then it 27 and rest 2 to 2 students,
  int the same way, i could take [15,10] or [10,9] at the end I have to take out the student who got maximum no of pages that should be minimum in all cases [10,9] who got the maximum pages in that possibilty but minimum among all.
 * 
 * 
 * 
 * 
 * 
 * so the intuition you cant just work on array. the initial thought is take oew maximum number and try it is possible to allocate them or not if it works, take a number which is less than that.
 * 
 * 
 * 
 * 
 * 
 */


public class 12.Allocatepages {
    public int binarysearch(int[] array, int k){
        int ans=-1;
        int low =Arrays.stream(array).max().getAsInt(); //y below these max element you cant allocate the pages to every student right if we take 1 pages is the max one if you try to allocate to student from array you cant right.
        int high=Arrays.stream(array).sum();
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(array,k,mid)){
                ans=mid;
                high=mid-1; 
            }
            else
            low=mid+1;
        }

        return ans;

    }
    public boolean possible(int[] array, int k  , int maxstudentpages){
        int student =1; // you are going to collect pages for student 1 in a greedy way until it crosses maxstudent pages, obviously you cant allocate right if its above the maxstudentpages
        int sum=0;
        for(int i =0;i<array.length;i++){
            if(sum+array[i]>maxstudentpages){
                // then I cant be able to allocate right so I need to start with new student
                student++;
                sum=array[i]; // new pages allocated
                if(student>k) return false;
            }
            else
              sum+=array[i];

        }
        return true;
    }
    
}

// Tip : just check a maximum number can be fit into the possible function if does fit,the min maximum number may fit and dont worry about the splits, if tere are 5 numbers in the array if they want 
// you to make 3 splits if you can do it in 1 split you can also do it 3 splits right since the arr.lenght is greater if it's not greater you can never make the split, so we can make as many splits we want
// until it does not surpass the array length if it's may be a bigger maximum number can accomdate it. so just check a max number fits or not if it fit reduce if it does nt increase/

/*Similar questiom
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 * 
 * 
 */
class Solution {
    public int splitArray(int[] arr, int k) {
      int ans=0;

        int low=Arrays.stream(arr).max().getAsInt();
        int high=Arrays.stream(arr).sum();
        while(low<=high){
            int mid=(low+high)/2;

            if(possible(arr,k,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
               low=mid+1;
        }

        return ans;
        
    }
    public boolean possible(int[] arr,int k, int max){

        int count=1;
        int sum=0;
        for(int i =0;i<arr.length;i++){
            if(sum+arr[i]>max)
            {
                sum=arr[i];
                count++;
                if(count>k) return false;
            }
            else
               sum+=arr[i];

        }
        return true;
    }
}