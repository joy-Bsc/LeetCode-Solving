package problemSolving;


import java.util.Arrays;

public class LeetCode11 {
    public static int threeSumClosest(int[] nums, int target){

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];


         for (int i = 0; i < nums.length - 2; i++) {
             int left = i+1;
             int right = nums.length - 1;
             while (left < right){
                 int current = nums[i] + nums[left] + nums[right];
                 if (Math.abs(current-target) < Math.abs(closest-target)){
                     closest = current;

                 }
                 if(current < target){
                     left++;
                 }
                 else if(current > target){
                     right--;
                 }
                 else{
                     return current;
                 }
             }
         }
         return closest;

    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}
