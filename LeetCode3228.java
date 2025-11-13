package problemSolving;

public class LeetCode3228 {
    public static int maxOperations(String s){
        int n = s.length();
        int zeros = 0;
        int operation = 0;
        for (int i = n - 1; i >= 0; ) {
            if (s.charAt(i) == '0') zeros++;
            while (i >= 0 && s.charAt(i) == '0') {
                    i--;
                }
                int ones = 0;
                while (i >= 0 && s.charAt(i) == '1') {
                    ones++;
                    i--;
                }
                operation += ones * zeros;

        }
        return operation;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations("1001101"));
    }
}
