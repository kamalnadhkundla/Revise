/*
 * 
 *   you are given an array of size N, and an element X you need to return index of it, but the twist is in the array some elements may be swapped with i-1 or i+1 or it lies in its position only.
 * 
 * Intuition : you know when you find a mid element through binary search , what will you do , you will check with the target and if its our target we return it right, but here some elements are swapped
 * with prev and next elements, so what will you do, we also check them right if anything match we return that index.
 * 
 * step 2 : my target is not in the either of the elements, now what?
 * so basically, eventhough it is swapped if your target is less than the mid element it still lies in the left handside right. but will you do mid-1 nah!! you already checked m-1 in step 1 so the next prev ele
 * so mid-2
 * that's it you got the answer.
 * 
 */




public class AlmostSortedArray {

    public static int solution(int[] arr, int target){
        int low =0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return mid;
            if(mid-1>=0 && arr[mid-1]==target)  return mid-1;
            if(mid+1<=arr.length-1 && arr[mid+1]==target) return mid+1;

            if(arr[mid]>target)
              //left hand side
              high=mid-2;
            else
                low=mid+1;


        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{10, 3, 40, 20, 50, 80, 70};
        System.out.println(solution(arr, 40));
    }

    
}
