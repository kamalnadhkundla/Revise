package stackandqueue;
/*
 * 
 *  just observe the given example all you do is you will take left greatest and right greatest and you will find the area between
 * like total+=min(leftmax,rightmax)-arr[i]   
 * 
 * one logic go bruteforce finding leftmax , rightmax for every element from that element.
 * 2 logic having prefix max and suffix max array.
 * 3 logic  : using 2 pointers approach
 * 
 * 
 * 
 * 
 */




public class  4.TrappingRainWater {

    // using prefixmax 
public int[] calcuatemaxwater(int[] array){
    int[] prefix= new int[array.length];
    int[] suffix= new int[array.lenght];
    prefix[0]=array[0];
    for(int i =1;i<array.length;i++){
        prefix[i]=Math.max(prefix[i-1],array[i]);

    }
    suffix[suffix.length-1]=array[array.length-1];
    for(int i=array.length-2;i>=0;i--){
        suffix[i]=Math.max(suffix[i+1],array[i]);
    }
    int res=0;
        for(int k =0;k<height.length;k++){
          res+=Math.min(prefixmax[k],suffixmax[k])-height[k];
        }
        return res;
}
    
}
