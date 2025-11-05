package problemSolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode3318 {
    static HashMap<Integer , Integer> hmap;
    public static int[] findXSum(int[] nums, int k, int x){
        hmap = new HashMap<>();
        int n = nums.length;
        int index = 0;
        int[] result = new int[n-k+1];
        for (int i = 0; i < n ; i++) {
            hmap.put(nums[i] ,hmap.getOrDefault(nums[i] , 0)+1);
            if(i >= k-1){

                result[index++] = getSum(x);
                int removeNum = nums[i-k+1];
                hmap.put(removeNum,hmap.get(removeNum)-1);
                if(hmap.get(removeNum)== 0) hmap.remove(removeNum);
            }
        }
        return result;
    }

    private static int getSum(int x) {
        int sum = 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
            {
                int f1 = hmap.get(a);
                int f2 = hmap.get(b);
                if(f1 == f2){
                    return b-a;
                }
                return f2-f1;
            }
        });
        for(int key : hmap.keySet()){
            pq.offer(key);
        }
        while (!pq.isEmpty() && x > 0){
            int top = pq.remove();
            sum += top*hmap.get(top);
            x--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,4,2,3};
        int[] nums2 = new int[]{3,8,7,8,7,5};
        int[] res = findXSum(nums,6,2);
        int[] res2 =findXSum(nums2 ,2,2);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }
}
