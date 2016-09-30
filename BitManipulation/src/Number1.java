/**
 * Created by siddharthvarshney on 9/11/16.
 */
public class Number1 {
    public static void main(String args[])
    {
        long num = 8;
        int count = 0;
        while(num > 0)
        {
            if((num&1) !=0)
            {
                count++;
            }
            num >>=1;
        }
        System.out.println(count);
    }
}
