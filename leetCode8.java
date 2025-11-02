package problemSolving;

import java.util.Arrays;
import java.util.stream.IntStream;

public class leetCode8 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){

       int[]c = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
       Arrays.sort(c);
        int n = c.length;
        if (n % 2 == 0){
            return( (c[(n/2)-1] + c[(n/2) ]) / 2.0);
        }
        else {
            return (c[n/2]) ;
        }

    }
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
