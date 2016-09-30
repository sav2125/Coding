/**
 * Created by siddharthvarshney on 9/27/16.
 */
public class KMP {
    static void Computelps(String pat, int [] lps)
    {
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while(i < pat.length())
        {
            if(pat.charAt(i) == pat.charAt(j))
            {
                lps[i] = j + 1;
                j++;
                i++;
            }
            else
            {
                if(j == 0)
                {
                    lps[i] = 0;
                    i++;
                }
                else
                {
                    j = lps[j-1];
                }
            }
        }
    }
    static public int stringMatching(String txt, String pat, int[] lps)
    {
        int i = 0;
        int j = 0;
        while(i < txt.length())
        {
            if(pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if(j == pat.length())
            {
                return (i - j);
            }
            else if(pat.charAt(j) != txt.charAt(i))
            {
                if(j == 0)
                    i++;
                else
                    j = lps[j-1];
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        int [] lps = new int[pat.length()];
        Computelps(pat,lps);
        System.out.print(stringMatching(txt,pat,lps));
        int x = 0;
    }
}
