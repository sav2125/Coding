/**
 * Created by siddharthvarshney on 9/27/16.
 */
import java.util.*;
public class WordBreak {
    static public int wordbreak(String test, ArrayList<String> dict)
    {
        if(test == null || test.isEmpty())
        return 1;
        int [] arr = new int[test.length() + 1];
        for(int i = 0;i < arr.length; i++)
        {
            arr[i] = 0;
        }
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[j] == 1 && dict.contains(test.substring(j,i)))
                {
                    arr[i] = 1;
                    break;
                }
            }
        }
        return arr[arr.length - 1];
    }
    public static void main(String args[])
    {
        String s = "leetcode";
        ArrayList<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.print(wordbreak(s,dict));
    }
}
