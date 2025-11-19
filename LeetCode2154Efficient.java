package problemSolving;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2154Efficient {
    public static int findFinalValue(int[] nums, int original){
        Set<Integer>set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        while(set.contains(original)){
            original *= 2;
        }
        return original;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,6,1,12};
        System.out.println(findFinalValue(nums,3));
    }
}
