package problemSolving;

public class LeetCode16 {
    public static int search(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] num = {4,5,6,7,0,1,2};
        System.out.println(search(num, 0));

    }
}
