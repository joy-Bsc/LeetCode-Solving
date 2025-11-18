package problemSolving;

public class LeetCode717 {
    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == n - 1;
    }

    public static void main(String[] args) {
        //int[] bits = new int[]{1,0,0};
        int[] bits2 = new int[]{1,1,1,0};
        //System.out.println(isOneBitCharacter(bits));
        System.out.println(isOneBitCharacter(bits2));
    }
}
