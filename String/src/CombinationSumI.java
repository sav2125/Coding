import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by siddharthvarshney on 9/27/16.
 */
public class CombinationSumI {
    static private  void  combinationSumUtil(ArrayList<ArrayList<Integer>> result, int[] candidates, int target, int index, ArrayList<Integer> output,int sum)
    {
        if(sum > target)
        {
            return;
        }
        if(sum == target)
        {
            result.add(new ArrayList<>(output));
            return;
        }
        for(int i = index; i < candidates.length; i++)
        {
            if(sum + candidates[i] > target)
                break;
            sum = sum + candidates[i];
            output.add(candidates[i]);
            combinationSumUtil(result,candidates,target,i,output,sum);
            sum = sum - candidates[i];
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
        int target = 7;
        int [] candidates = {2,3,7,6};
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = combinationSum(candidates, target);
        int x = 0;
    }
}
