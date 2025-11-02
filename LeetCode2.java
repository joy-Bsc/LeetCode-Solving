package problemSolving;

public class LeetCode2 {

    public static String longestPalindrome(String s) {
       int l1,l2,l;
       int start = 0 ;
       int end = 0 ;
        if (s == null || s.length() < 1) return "";

        for (int i = 0; i <s.length() ; i++) {
            l1 = expandAroundCenter(s,i,i);
            l2 = expandAroundCenter(s,i,i+1);
            l = Math.max(l1,l2);

            if(l > end-start){
                start = i - (l - 1)/2;
                end = i + l/2;
            }

        }
        return s.substring(start,end+1);

    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

        }
        return right - left - 1;
    }
    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
    }
}
