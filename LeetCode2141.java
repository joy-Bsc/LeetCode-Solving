package problemSolving;

public class LeetCode2141 {
    public static long maxRunTime(int n, int[] batteries){
        long sum = 0;
        for(int battery : batteries){
            sum += battery;
        }
        long left = 1;
        long right = sum/n;
        long ans = 0;
        while (left <= right){
            long mid = left + (right - left)/2;
            if(canRun(batteries , n , mid)){
               ans = mid;
                left = mid+1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canRun(int[] batteries, int n, long time) {
        long total = 0;
        for(int battery : batteries){
            total += Math.min(battery , time);
        }
        return  total >= (long) n * time;
    }

    public static void main(String[] args) {
        int[] batteries = new int[]{3,3,3};
        int[] batteries2 = new int[]{1,1,1,1};
        int[] batteries3 = new int[]{10,10,3,5};
        System.out.println(maxRunTime(2,batteries));
        System.out.println(maxRunTime(2,batteries2));
        System.out.println(maxRunTime(3,batteries3));
    }
}
