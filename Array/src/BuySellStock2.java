/**
 * Created by siddharthvarshney on 9/15/16.
 */
public class BuySellStock2 {
    static public void func2(int [] prices)
    {
        int [] left = new int[prices.length];
        int [] right = new int[prices.length];
        for(int i=0;i< prices.length;i++)
        {
            left[i] =  0;
            right[i] = 0;
        }
        int min = prices[0];
        for(int i = 1 ; i < prices.length; i++)
        {
            left[i] = Math.max(left[i-1],prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >=0 ; i--)
        {
            right[i] = Math.max(right[i+1],max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int result = 0;
        for(int i = 0; i < prices.length; i++)
        {
            result = Math.max(result, left[i] + right[i]);
        }
        System.out.print(result);
    }
    public static void main(String args[])
    {
        int prices[] = {10, 22, 5, 75, 65, 80};
        func2(prices);
    }
}
