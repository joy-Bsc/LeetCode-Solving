package problemSolving;

public class LeetCode2154 {
    public static int findFinalValue(int[] nums, int original){
      boolean isFound = true;
      while(isFound){
          isFound = false;
          for(int num : nums){
              if(num == original){
                  original = original*2;
                  isFound = true;
                  break;
              }
          }
      }
      return original;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,6,1,12};
        System.out.println(findFinalValue(nums,3));
    }
}
