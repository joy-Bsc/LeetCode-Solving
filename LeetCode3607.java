package problemSolving;

import java.util.*;

public class LeetCode3607 {
   static HashMap<Integer , List<Integer>> graph;
   static int[] mapping;
    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        graph = new HashMap<>();
        for (int i = 0; i <= c; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] connection : connections){
            int src = connection[0];
            int dest = connection[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        int curr = 1;
        mapping = new int[c+1];
        for (int i = 1; i<=c ; i++ ){
            if (mapping[i] == 0){
                dfs(i , curr);
                curr++;
            }
        }
        HashMap<Integer , TreeSet<Integer>> onLineGrid = new HashMap<>();
        for (int i = 0; i <= c; i++) {
            int gridValue = mapping[i];
            onLineGrid.putIfAbsent(gridValue , new TreeSet<>());
            onLineGrid.get(gridValue).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int[] query : queries){
            int type = query[0];
            int node = query[1];
            int gridValue = mapping[node];
            TreeSet<Integer> set = onLineGrid.get(gridValue);
            if(type == 1){
                if(set.contains(node)){
                    ans.add(node);
                }else {
                    ans.add(set.isEmpty() ? -1 : set.first());
                }
            } else if (type == 2) {
                set.remove(node);
            }
        }
        return ans.stream().mapToInt(Integer :: intValue).toArray();
    }
    private static void dfs(int node , int gridValue){
        if(mapping[node] != 0)
            return;
        mapping[node] = gridValue;
        for(int nei : graph.get(node)){
            if(mapping[nei] == 0){
                dfs(nei , gridValue);
            }
        }
    }

    public static void main(String[] args) {
        int[][] connection = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] query = new int[][]{{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}};

        int c = 5;
        int[] res = processQueries(c,connection,query);
        System.out.println(Arrays.toString(res));
    }

    }
