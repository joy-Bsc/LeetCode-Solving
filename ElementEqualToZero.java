package problemSolving;

import java.sql.Array;
import java.util.Arrays;

public class ElementEqualToZero {
    public static int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i =0 ; i< n ; i++){
            if(nums[i] == 0){
                if(validSelections(nums , i , true)){
                    count++;
                }
                if(validSelections(nums , i , false)){
                    count++;
                }
            }
        }
        return count;

    }

    private static boolean validSelections(int[] nums, int i, boolean moveRight) {
        int[] arr = Arrays.copyOf(nums , nums.length);
        int curr = i;
        int dir = moveRight ? 1 : -1;
        while (curr >= 0 && curr <arr.length){
            if (arr[curr]== 0){
                curr += dir;
            }
            else{
                arr[curr]--;
                dir *= -1;
                curr += dir;
            }
        }

        for(int num : arr){
            if(num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 0, 3};
        System.out.println(countValidSelections(nums1));
    }
}
