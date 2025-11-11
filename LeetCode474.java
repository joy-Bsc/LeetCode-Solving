package problemSolving;

public class LeetCode474 {
    public static int findMaxForm(String[] strs, int m, int n){
        Integer [][][] dp = new  Integer[strs.length + 1][m+1][n+1];
        return helper(strs,m,n,0 , dp );
    }
    private static int helper(String[] strs ,int m , int n , int i ,Integer[][][]dp ){
        if(i == strs.length) return 0;
        if(dp[i][m][n] != null){
            return dp[i][m][n];
        }
        int notPick = helper(strs , m , n , i+1 , dp);
        int zeros = 0 , ones = 0;
        for(char c : strs[i].toCharArray()){
            if(c == '0'){
                zeros += 1;
            }else {
                ones += 1;
            }
        }
        int pick = 0;
        if(m >= zeros && n >= ones){
            pick = 1 + helper(strs , m-zeros , n-ones , i+1 , dp);
        }
        int result = Math.max(pick , notPick);
        dp[i][m][n] = result;
        return dp[i][m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10","0001","111001","1","0"};
        String[] strs2 = new String[]{"10","0","1"};
        System.out.println(findMaxForm(strs,5,3));
        System.out.println(findMaxForm(strs2,1,1));
    }
}
