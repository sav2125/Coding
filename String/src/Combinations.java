import java.util.ArrayList;

/**
 * Created by siddharthvarshney on 9/11/16.
 */
public class Combinations {
    static public void combinations(int [] array, int start, int m, int k, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result)
    {
        if(m == k)
        {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = start; i< array.length;i++)
        {
            temp.add(array[i]);
            combinations(array,i+1,m+1,k,temp,result);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String args[])
    {
        int n = 4;
        int k = 2;
        if(n <= 0 || k <= 0 || n < k)
            return;
        int [] array = new int[n];
        for(int i=0;i<n;i++)
            array[i] = i+1;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinations(array, 0, 0, k, temp,result);
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
}
