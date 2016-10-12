/**
 * Created by siddharthvarshney on 9/12/16.
 */
public class Permutations {
    static void swap(char[] num, int left, int right)
    {
        char temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
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
                swap(num,start,i);
                permutation(num, start + 1, end);
                swap(num,start,i);
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
