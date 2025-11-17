package problemSolving;

import java.sql.Array;
import java.util.Arrays;

public class LeetCode1437 {
    public static boolean kLengthApart(int[] nums , int k){

        int n = nums.length;
        int[] temp = new int[n];
        int len = 0;
        boolean bool = true;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                temp[len++]=i;
            }
        }
        int[] arr = new int[len];
        System.arraycopy(temp, 0, arr, 0, len);
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1]) <= k) {
                bool = false;
                continue;
            }
        }

        return bool;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,1,0,0,1};
        int[] nums2 = new int[]{1,0,0,1,0,1};
        System.out.println((kLengthApart(nums,2)));
        System.out.println(kLengthApart(nums2,2));
    }
}
