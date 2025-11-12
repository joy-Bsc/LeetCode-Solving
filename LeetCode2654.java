package problemSolving;

public class LeetCode2654 {
    public static int minOperations(int[] nums){
        int n = nums.length;
        int ones = 0 ;
        int totalOperation = 0;
        for (int num : nums){
            if(num == 1) ones++;
        }
        if(ones > 0){
            return n - ones ;
        }
        int minimumLength = Integer.MAX_VALUE;
        for (int i  = 0; i  < n; i ++) {
            int gcd1 = nums[i];
            for (int j = i+1; j < n; j++) {
                gcd1 = gcd(gcd1,nums[j]);
                if(gcd1 == 1){
                    minimumLength = Math.min(minimumLength , j-i + 1);
                    break;
                }
            }
        }
        if(minimumLength == Integer.MAX_VALUE){
            return -1;
        }
        totalOperation = (minimumLength - 1) + (n - 1);
        return totalOperation;
    }

    private static int gcd(int a, int b) {
        if(b != 0){
            return gcd(b , a%b);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {2,6,3,4};
        int[] nums2 = new int[] {2,10,6,14};
        System.out.println(minOperations(nums1));
        System.out.println(minOperations(nums2));

    }
}
