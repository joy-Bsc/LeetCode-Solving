package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode20 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    private static void backtrack(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;

        }
        for(int i = start; i < candidates.length; i++){
            if(i>start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target < candidates[i]){
                break;
            }
            list.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1,list,res);
            list.remove(list.size()-1);
        }
    }
     public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
     }
}
