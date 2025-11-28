package problemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode2872 {
    static HashMap<Integer , List<Integer>> hMap;
    static HashSet<Integer> visited;
    static int count ;
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k){
        hMap = new HashMap<>();
        visited = new HashSet<>();
        for(int i = 0 ; i<n; i++){
            hMap.put(i,new ArrayList<>());
        }
        for(int edge[] : edges){
            int src = edge[0];
            int dest = edge[1];
            hMap.get(src).add(dest);
            hMap.get(dest).add(src);
        }
        count = 0;
        helper(0 , values , k);
        return count;
    }
    static int helper(int src , int values[] , int k){
        if(visited.contains(src)){
            return 0;
        }
        visited.add(src);
        int sum = values[src];
        List<Integer> list = hMap.get(src);
        for(int curr : list){
            sum += helper(curr , values , k);
        }
        if(sum % k == 0) count++;
        return sum%k;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[][] edges1 = new int[][]{{0,2},{1,2},{1,3},{2,4}};
        int[] values1 = new int[]{1,8,1,4,4};
        int k1 = 6;
        int n2 = 7;
        int[][] edges2 = new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values2 = new int[]{3,0,6,1,5,2,1};
        int k2 = 3;
        System.out.println(maxKDivisibleComponents(n1,edges1,values1,k1));
        System.out.println(maxKDivisibleComponents(n2,edges2,values2,k2));

    }
}
