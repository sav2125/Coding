/**
 * Created by siddharthvarshney on 9/18/16.
 * Given s = "the sky is blue"
 * return "blue is sky the".
 */
public class ReverseString {
    static void reverse(char[] str, int start, int end)
    {
        int len = end - start + 1;
        int ending = start + (len/2);
        while(start < ending)
        {
            char temp = str[start];
            str[start] = str[start + len - 1];
            str[start + len - 1] = temp;
            start++;
        }
    }
    public static  void main(String args[])
    {
        String str = "  the   sky is blue  ";
        String test = str.trim();
        char [] sample = test.toCharArray();
        int lensample = sample.length;
        int start = 0;
        int end = 0;
        System.out.println(sample);
        reverse(sample, 0, sample.length - 1);
        System.out.println(sample);
        while(end < lensample)
        {
            while(sample[start] == ' ')
                start++;
            end = start;
            while(sample[end] != ' ' && end != lensample)
            {
                end++;
            }
            reverse(sample, start, end - 1);
            start = end;
        }
        System.out.println(sample);
    }
}
