import java.util.HashMap;

/**
 * Created by siddharthvarshney on 9/20/16.
 */
public class LargestSubarray0Sum {
    static public int maxLen(int [] arr)
    {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0;
        int arr_len = arr.length;
        int maxLen = 0;
        for(int i = 0; i < arr_len; i++)
        {
            sum = sum + arr[i];
            if(arr[i] == 0)
            {
                maxLen = Math.max(maxLen , 1);
            }
            if(sum == 0)
            {
                maxLen = Math.max(maxLen, i + 1);
            }
            else
            {
                if(hash.get(sum) == null)
                {
                    hash.put(sum , i);
                }
                else
                {
                    int prev_index = hash.get(sum);
                    maxLen = Math.max(maxLen, i - prev_index );
                }
            }
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));

    }
}
