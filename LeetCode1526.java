package problemSolving;

public class LeetCode1526 {
    public static int minNumberOperations(int[] target){
        int operation = target[0];
        for (int i = 1; i < target.length; i++) {
            if(target[i] > target[i-1]){
                operation += target[i] - target[i-1];
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 0, 3};
        System.out.println(minNumberOperations(new int[]{1,2,3,2,1}));
    }
}
