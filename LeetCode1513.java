package problemSolving;

public class LeetCode1513 {
    public static int numSub(String s){
        long count = 0;
        long result = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                result = (result + count) % mod;
            } else {
                count = 0;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
    }
}
