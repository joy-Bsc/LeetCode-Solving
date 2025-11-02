package problemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode19 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List <List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;

    }
    private static void backtrack(int[] candidates, int target, int start, List<Integer>list, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] <= target){
                list.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i , list, res);
                list.remove(list.size()-1);

            }
        }
    }
     public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
         System.out.println(combinationSum(candidates, target));
     }
}
