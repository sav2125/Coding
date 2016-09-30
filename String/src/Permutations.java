/**
 * Created by siddharthvarshney on 9/12/16.
 */
public class Permutations {
    static public void permutation(char[] num, int start,int end)
    {
        if(start == end)
        {
            System.out.println(new String(num));
        }
        else
        {
            for (int i = start; i <= end; i++)
            {
                char temp = num[start];
                num[start] = num[i];
                num[i] = temp;
                permutation(num, start + 1, end);
                temp = num[start];
                num[start] = num[i];
                num[i] = temp;
            }
        }
    }
    public static void main(String args[])
    {
        String num = "123";
        char[] array = num.toCharArray();
        permutation(array,0,array.length - 1);
    }
}
