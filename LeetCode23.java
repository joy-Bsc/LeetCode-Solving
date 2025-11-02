package problemSolving;

import java.util.ArrayList;
import java.util.List;

public class LeetCode23 {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,new ArrayList<>(),visited,res);
        return res;
    }
    private static void backtrack(int[] nums, List<Integer> list, boolean[] visited, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;

        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backtrack(nums,list,visited,res);
                visited[i] = false;
                list.remove(list.size()-1);

            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permute(nums));
    }
}
