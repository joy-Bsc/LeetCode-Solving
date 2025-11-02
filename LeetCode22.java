package problemSolving;

public class LeetCode22 {
    public static int jump(int[] nums){
       int count=0;
       int f=0 , c=0;
        for (int i = 0; i < nums.length-1; i++) {
             f = Math.max(f, i+nums[i]);

             if(i == c ){
                 count++;
                 c=f;
             }
        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println( jump(new int[]{2,3,0,1,4}));

    }
}
