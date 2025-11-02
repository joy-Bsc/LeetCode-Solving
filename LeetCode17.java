package problemSolving;

public class LeetCode17 {
    public static int[] searchRange(int[] nums, int target){
         int[] res = {-1, -1};

         for (int i = 0; i < nums.length; i++) {
             if(nums[i] == target)
             {
                if(res[0] == -1){
                    res[0] = i;
                }
                res[1] = i;

             }


         }
         return res;

    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
