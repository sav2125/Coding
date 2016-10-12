/**
 * Created by siddharthvarshney on 9/11/16.
 */
import java.util.*;
public class Subset {
    static public void subset(int [] array, int index, ArrayList<Integer> result)
    {
        if(index >= array.length)
        {
            return;
        }
        for(int i = index; i < array.length; i++)
        {
            result.add(array[i]);
            System.out.println(result);
            subset(array, i + 1, result);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String args[])
    {
        int [] array = {3,1,2};
        Arrays.sort(array);
        ArrayList<Integer> result = new ArrayList<Integer>();
        subset(array, 0, result);
    }
}
