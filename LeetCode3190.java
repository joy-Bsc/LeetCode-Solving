package problemSolving;

public class LeetCode3190 {
    public static int minimumOperations(int[] nums){
        int count = 0;
        for(int num : nums){
            if(num%3==2){
                count++;
            } else if (num%3==1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] nums2 = new int[]{3,6,9};
        System.out.println(minimumOperations(nums));
        System.out.println(minimumOperations(nums2));
    }
}
