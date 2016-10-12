import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
/**
 * Created by siddharthvarshney on 9/27/16.
 */
public class CombinationSumII {
    static public void combinationSumUtil(ArrayList<ArrayList<Integer>> result,int[] candidates,int target,int index,ArrayList<Integer> output, int sum)
    {
        if(sum > target)
            return;
        if(sum == target)
        {
            result.add(new ArrayList<>(output));
        }
        for(int i = index; i < candidates.length; i++)
        {
            if(i != index && (candidates[i] == candidates[i-1] ))
            {
                continue;
            }
            if(sum + candidates[i] > target)
                return;
            output.add(candidates[i]);
            combinationSumUtil(result,candidates,target,i + 1,output, sum + candidates[i]);
            output.remove(output.size() - 1);
        }
    }
    static public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(candidates.length == 0 || candidates == null)
            return result;
        combinationSumUtil(result, candidates, target, 0, new ArrayList<Integer>(), 0);
        return result;
    }
    public static void main(String args[])
    {

        int target = 8;
        int[] candidates = {10,1,2,7,6,1,5};
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = combinationSum(candidates, target);
        int x = 0;
    }
}
