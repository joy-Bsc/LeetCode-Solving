package problemSolving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode757 {
    public static int intersectionSizeTwo(int[][] intervals){
        HashSet<Integer>set = new HashSet<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int max = intervals[0][1];
        int secondMax = max - 1;
        set.add(max);
        set.add(secondMax);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= secondMax){
                continue;
            } else if (intervals[i][0] <= max) {
                secondMax = max;
                max = intervals[i][1];
                if(set.contains(max)){
                    set.add(max-1);
                    secondMax = max-1;
                }
                set.add(max);
            }else {
                max=intervals[i][1];
                secondMax=max-1;
                set.add(max);
                set.add(secondMax);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{3,7},{8,9}};
        System.out.println(intersectionSizeTwo(intervals1));
    }
}
