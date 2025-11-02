package problemSolving;

public class LeetCode14 {
    public static int removeElement(int[] nums, int val){
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; j++){
            if (nums[j] == val){
                nums[i] = nums[j];
                i++;
            }

        }


         return i;
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement( nums, 3));
    }
}
