/**
 * Created by siddharthvarshney on 10/2/16.
 */
import java.util.ArrayList;
import java.util.StringJoiner;

public class SummaryRanges {
    static public ArrayList<String> summaryRanges(int[] arr)
    {
        ArrayList<String> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return result;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(arr[0]));
        int prev = arr[0];
        int curr = 0;
        for(int i = 1; i < arr.length; i++)
        {
            curr = arr[i];
            if(curr == prev + 1)
            {
                if(sb.charAt(sb.length() - 1) == '>')
                {
                    prev = curr;
                }
                else
                {
                    sb.append('-');
                    sb.append('>');
                    prev = curr;
                }
                if(i == arr.length - 1)
                    sb.append(curr);
            }
            else
            {
                if(sb.charAt(sb.length() - 1) == '>')
                {
                    sb.append(String.valueOf(prev));
                    prev = arr[i];
                    result.add(sb.toString());
                    sb.setLength(0);
                    sb.append(String.valueOf(prev));
                }
                else
                {
                    result.add(sb.toString());
                    sb.setLength(0);
                    sb.append(String.valueOf(arr[i]));
                    prev = arr[i];
                }
            }
        }
        result.add(sb.toString());
        return result;
    }
    public static void main(String args[])
    {
        int [] nums = {0,1,2};
        ArrayList<String> result = summaryRanges(nums);
        System.out.println(result);
    }
}
