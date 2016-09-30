/**
 * Created by siddharthvarshney on 9/14/16.
 */
public class Permutationsii {
    static void permutationsii(char[] array, int start,int end)
    {
        if(start == end)
        {
            System.out.println(new String(array));
        }
        for(int i = start; i <= end; i++)
        {
            char temp = array[start];
            array[start] = array[i];
            array[i] = temp;
            permutationsii(array,start+1,end);
            temp = array[start];
            array[start] = array[i];
            array[i] = temp;
            while((i < array.length - 1) && array[i] == array[i+1])
            {
                i++;
            }
        }
    }
    public static void main(String args[])
    {
        String num = "122";
        char[] array = num.toCharArray();
        permutationsii(array,0,array.length - 1);
    }
}
