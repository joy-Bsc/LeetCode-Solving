package problemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1262 {
    public static int maxSumDivThree(int[] nums){
        List<Integer>reminding1 = new ArrayList<>();
        List<Integer>reminding2 = new ArrayList<>();
        int total = 0;
        for(int num : nums){
            total += num;
            if(num%3==1){
                reminding1.add(num);
            } else if (num%3==2) {
                reminding2.add(num);
            }
        }
        Collections.sort(reminding1);
        Collections.sort(reminding2);
        if(total %3 == 0) return total;
        else if(total%3==1){
            int option1 = !reminding1.isEmpty() ?total-reminding1.getFirst():0;
            int option2 = reminding2.size()>1?total-reminding2.get(0)-reminding2.get(1):0;
            return Math.max(option1,option2);
        }
        else if(total%3==2){
            int option1 = !reminding2.isEmpty() ?total-reminding2.getFirst():0;
            int option2 = reminding1.size()>1?total-reminding1.get(0)-reminding1.get(1):0;
            return Math.max(option1,option2);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,6,5,1,8};
        int[] nums2 = new int[]{4};
        int[] nums3 = new int[]{1,2,3,4,4};
        int[] nums4 = new int[]{5,2,2,2};
        System.out.println(maxSumDivThree(nums1));
        System.out.println(maxSumDivThree(nums2));
        System.out.println(maxSumDivThree(nums3));
        System.out.println(maxSumDivThree(nums4));

    }
}
