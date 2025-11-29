package problemSolving;

public class LeetCode3512 {
    public static int minOperations(int[] nums, int k){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return sum % k;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {3,9,7};
        int[] nums2 = new int[]{4,1,3};
        int[] nums3 = new int[]{3,2};
        System.out.println(minOperations(nums1,5));
        System.out.println(minOperations(nums2,4));
        System.out.println(minOperations(nums3,6));
    }
}
