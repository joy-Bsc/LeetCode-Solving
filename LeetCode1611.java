package problemSolving;

public class LeetCode1611 {
    public static int minimumOneBitOperations(int n) {
        int result = 0;
        while (n > 0) {
            result ^= n;
            n >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(9)); // Output: 2
    }

}
