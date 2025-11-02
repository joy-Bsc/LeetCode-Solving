package problemSolving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1 {
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0;
        int longest = 0;

        for (int right = 0; right <n ; right++) {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);

        }
        return longest;
    }
    public static void main(String[] args) {
         System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }
}
