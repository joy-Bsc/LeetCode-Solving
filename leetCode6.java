package problemSolving;

import java.util.HashMap;

public class leetCode6 {
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int total = 0;
        int prevVal = 0;
        int curVal = 0;
        for (int i = s.length()-1; i>= 0; i--) {
            curVal = map.get(s.charAt(i));
           if(curVal < prevVal) {
               total -= curVal;
           }
           else {
               total += curVal;
           }
           prevVal = curVal;

        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
