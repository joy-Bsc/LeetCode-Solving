package problemSolving;

public class leetCode {
    public static int myAtoi(String s){
        int i = 0;
        int sign = 1;
        int result = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if(i < s.length() && s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;

        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println(myAtoi("   -042"));
    }
}
