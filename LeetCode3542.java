package problemSolving;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode3542 {
    public int minimumOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ops = 0;

        for (int v : nums) {
            if (v == 0) {
                stack.clear();
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast() > v) {
                stack.removeLast();
            }

            if (stack.isEmpty() || stack.peekLast() < v) {
                stack.addLast(v);
                ops++;
            }
        }

        return ops;
    }
    // Example run
    public static void main(String[] args) {
        LeetCode3542 sol = new LeetCode3542();

        System.out.println(sol.minimumOperations(new int[]{0, 2}));        // 1
        System.out.println(sol.minimumOperations(new int[]{3, 1, 2, 1}));  // 3
        System.out.println(sol.minimumOperations(new int[]{1, 2, 1, 2, 1, 2})); // 4
    }
}
