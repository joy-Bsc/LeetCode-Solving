package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1018 {
    public static List<Boolean> prefixesDivBy5(int[] nums){
        List<Boolean>result = new ArrayList<>();
        int prefixMod = 0;
        for(int bit : nums){
            prefixMod = ((prefixMod << 1)+bit)%5;
            result.add((prefixMod==0));
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,1};
//        System.out.println(Arrays.toString(new List[]{prefixesDivBy5(nums)}));
//        int[] nums2 = new int[]{1,1,1};
//        System.out.println(Arrays.toString(new List[]{prefixesDivBy5(nums2)}));
        int[] nums3 = new int[]{1,1,1,1};
        System.out.println(Arrays.toString(new List[]{prefixesDivBy5(nums3)}));
    }
}
