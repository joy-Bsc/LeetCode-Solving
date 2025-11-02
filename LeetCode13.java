package problemSolving;

import java.util.Arrays;

public class LeetCode13 {
    public static int[] removeDuplicates(int[] nums){
        //if (nums == null || nums.length == 0) return 0;


        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){

                i++;
                nums[i] = nums[j];
            }

        }
        return Arrays.copyOfRange(nums,0,i+1);

    }
    public static void main(String[] args) {
          System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 2, 3, 3, 4})));

    }
}
