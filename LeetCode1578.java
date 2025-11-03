package problemSolving;

public class LeetCode1578 {
    public static int minCost(String colors, int[] neededTime){
        int totalTime = 0;
        int maxTime = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            if(colors.charAt(i-1) == colors.charAt(i)){
                totalTime += Math.min(maxTime , neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            }

                else{
                   maxTime = neededTime[i];
                }
            }

        return totalTime;
    }

    public static void main(String[] args) {
        String colors = "aabaa";
        int[] nt = new int[]{1,2,3,4,1};
        System.out.println(minCost(colors,nt));
    }
}
