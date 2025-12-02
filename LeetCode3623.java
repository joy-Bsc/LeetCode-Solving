package problemSolving;

import java.util.HashMap;

public class LeetCode3623 {
    public static int countTrapezoids(int[][] points){
        HashMap<Integer,Integer> hMap = new HashMap<>();
        int mod = 1000000007;
        long ans = 0 ;
        long totalEdges = 0;
        for (int point [] : points){
            hMap.put(point[1],hMap.getOrDefault(point[1],0)+1);
        }
        for (int num : hMap.values()){
            long edges = ((long) num *(num-1))/2;
            ans = (ans + totalEdges * edges)%mod;
            totalEdges = (totalEdges + edges)%mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int [][] points = new int[][]{{1,0},{2,0},{3,0},{2,2},{3,2}};
        int [][] points2 = new int[][]{{0,0},{1,0},{0,1},{2,1}};
        System.out.println(countTrapezoids(points));
        System.out.println(countTrapezoids(points2));
    }
}
