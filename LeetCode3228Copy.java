package problemSolving;

public class LeetCode3228Copy {
    public static int maxOperations(String s) {
        int operations = 0;
        int zeros = 0;
        int pendingOnes = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
                if (pendingOnes > 0) {
                    operations++;
                    pendingOnes--;
                }
            } else { // c == '1'
                if (zeros > 0) {
                    operations++;
                    zeros--;
                } else {
                    pendingOnes++;
                }
            }
        }

        return operations;
    }


    public static void main(String[] args) {
       // System.out.println(maxOperations("1001101")); // ✅ 4
        System.out.println(maxOperations("00111"));   // ✅ 0
        //System.out.println(maxOperations("010010"));  // ✅ 5
        //System.out.println(maxOperations("101010"));  // ✅ 6
    }
}
