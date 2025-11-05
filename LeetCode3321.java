package problemSolving;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode3321 {
    static HashMap<Integer, Integer> hmap;

    public static long[] findXSum(int[] nums, int k, int x) {
        hmap = new HashMap<>();
        int n = nums.length;
        long[] result = new long[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
            if (i >= k - 1) {
                result[index++] = getSum(x);
                int removedNum = nums[i - k + 1];
                hmap.put(removedNum, hmap.get(removedNum) - 1);
                if (hmap.get(removedNum) == 0) hmap.remove(removedNum);
            }
        }
        return result;
    }

    private static long getSum(int x) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int freqA = hmap.get(a);
            int freqB = hmap.get(b);
            if (freqA == freqB) {
                return Integer.compare(b, a); // descending order by key if freq equal
            }
            return Integer.compare(freqB, freqA); // descending order by frequency
        });

        for (int key : hmap.keySet()) {
            pq.offer(key);
        }

        while (!pq.isEmpty() && x > 0) {
            int top = pq.poll();
            sum += (long) top * hmap.get(top);
            x--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;

        long[] result = findXSum(nums, k, x);

        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}