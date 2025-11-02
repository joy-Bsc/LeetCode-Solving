package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3289 {
    public static int[] getSneakyNumbers(int[] nums){
        Arrays.sort(nums);
        int[] sneakyNums = new int[2];
        int index = 0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i-1] == nums[i]){
               sneakyNums[index++]= nums[i];
               if(index == 2) break;
            }

        }
        return sneakyNums;
    }

    public static void main(String[] args) {
        int[] a = {0,3,2,1,3,2};
         int[] res = getSneakyNumbers(a);
        System.out.println(Arrays.toString(res));
    }
}
