package problemSolving;

public class leetCode4 {
    public static boolean isMatch(String s, String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean isFirstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if(p.length()>=2 && p.charAt(1)== '*'){
           return( isMatch(s,p.substring(2))) || (isFirstMatch && isMatch(s.substring(1),p));
        }
        else {
            return isFirstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }
    public static void main(String[] args) {
         System.out.println(isMatch("aa","a"));
         System.out.println(isMatch("aa","a*"));
    }
}
