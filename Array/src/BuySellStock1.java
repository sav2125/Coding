/**
 * Created by siddharthvarshney on 9/15/16.
 */
public class BuySellStock1 {
    static void func(int prices[])
    {
        int len = prices.length;
        int min = prices[0];
        int maxdiff = 0;
        for(int i = 1; i < len; i++)
        {
            maxdiff = Math.max(maxdiff, prices[i] - min);
            if(prices[i] < min)
                min = prices[i];
        }
        System.out.println(maxdiff);
    }
    public static void main(String args[])
    {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        func(prices);
    }
}
