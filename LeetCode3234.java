package problemSolving;

public class LeetCode3234 {
    public static int numberOfSubstrings(String s){
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int one=0;
            int zero=0;
            for (int j = i; j <n ; j++) {
                if(s.charAt(j)=='1'){
                    one++;
                }
                else {
                    zero++;
                }
                if(one >= zero * zero){
                    count++;
                }else {
                    continue;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("00011"));
        System.out.println(numberOfSubstrings("101101"));
    }
}
