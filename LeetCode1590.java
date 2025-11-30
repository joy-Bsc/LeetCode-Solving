package problemSolving;

import java.util.HashMap;

public class LeetCode1590 {
    public static int minSubarray(int[] nums, int p){
        long sum = 0;
        for(int num : nums){
            sum += num;
        }
        int reminder = (int)(sum % p);
        if(reminder == 0 ) return 0;
        HashMap<Integer,Integer> hMap = new HashMap<>();
        hMap.put(0,-1);
        int currentSum = 0;
        int minimumLength = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            currentSum = (currentSum + nums[i]) % p ;
            int val = (currentSum - reminder + p )%p;
            if(hMap.containsKey(val)){
                minimumLength = Math.min(minimumLength , i-hMap.get(val));
            }
            hMap.put(currentSum,i);
        }
            return minimumLength == nums.length? -1 : minimumLength;
    }

    public static void main(String[] args) {
        int[]  nums1 = new int[]{3,1,4,2};
        int[] nums2 = new  int[]{6,3,5,2};
        int[] nums3 = new int[]{1,2,3};
        int[] nums4 = new int[]{1000000000,1000000000,1000000000};
        System.out.println(minSubarray(nums1,6));
        System.out.println(minSubarray(nums2,9));
        System.out.println(minSubarray(nums3,3));
        System.out.println(minSubarray(nums4 , 3));
    }
}
