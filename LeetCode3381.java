package problemSolving;

public class LeetCode3381 {
    public static long maxSubarraySum(int[] nums, int k){
        int n = nums.length;
        long prefix[] = new long[n+1];
        for (int i = 1 ; i<=n ;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            long sum = 0;
            for (int j = i ; j+k<=n ; j+=k){
                long currSum = prefix[j+k] - prefix[j];
                sum += currSum;
                if(sum < currSum){
                    sum = currSum;
                }
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int[] nums2 = new int[]{-1,-2,-3,-4,-5};
        int[] nums3 = new int[]{-5,1,2,-3,4};
        System.out.println(maxSubarraySum(nums,1));
        System.out.println(maxSubarraySum(nums2,4));
        System.out.println(maxSubarraySum(nums3,2));
    }
}
