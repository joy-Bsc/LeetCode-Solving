package problemSolving;

import java.util.ArrayList;
import java.util.List;

public class LeetCode26 {

    public static boolean hasSameDigits(String s){
        List<Integer>digits = new ArrayList<>();
        for(char c : s.toCharArray()){
            digits.add(c - '0');
        }
        while(digits.size()>2){
            List<Integer>next = new ArrayList<>();
            for(int i =0 ; i<digits.size()-1 ;i++){
                int sumMod = (digits.get(i) + digits.get(i+1))%10;
                next.add(sumMod);
            }
            digits = next;
        }
        return digits.get(0).equals(digits.get(1));
    }

    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));
    }
}
