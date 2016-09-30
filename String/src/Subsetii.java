import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by siddharthvarshney on 9/12/16.
 */
public class Subsetii {
    static public boolean dup(int[] array, int start, int end)
    {
        for(int i=start;i <=end-1;i++)
        {
            if(array[i] == array[end])
                return true;
        }
        return false;
    }
    static void subsetii(int [] array, int index, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> finalResult)
    {
        if(index >= array.length)
        {
            return;
        }
        for(int i=index;i < array.length;i++)
        {
            result.add(array[i]);
            finalResult.add(new ArrayList<Integer>(result));
            subsetii(array, i + 1, result,finalResult);
            result.remove(result.size() - 1);
            while (i<(array.length - 1) && array[i]==array[i+1])
            {
                i++;
            }
        }
    }
    public static void main(String args[])
    {
        int [] array = {2,1,2};
        Arrays.sort(array);
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>();
        subsetii(array, 0, result,finalResult);
        for(int i=0; i<finalResult.size();i++)
        {
            System.out.println(finalResult.get(i));
        }
    }
}
