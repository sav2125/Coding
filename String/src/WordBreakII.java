import java.util.ArrayList;

/**
 * Created by siddharthvarshney on 9/30/16.
 */
public class WordBreakII {
    static private boolean isBreakable(String s, ArrayList<String> dict)
    {
        if(s == null || s.length() ==0)
            return true;
        int len = s.length();
        boolean dp [] = new boolean[len + 1];
        for(int i = 0;i < dp.length; i++)
            dp[i] = false;
        dp[0] = true;
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(dp[j] && dict.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
    static private void wordBreakIIUtil(String s, ArrayList<String> dict, ArrayList<String> result, String output)
    {
        if(s.length() == 0)
        {
            result.add(output);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++)
        {
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString()))
            {
                String newOutput = output.length() > 1 ? output + " " + sb.toString() : sb.toString();
                wordBreakIIUtil(s.substring(i + 1), dict, result, newOutput);
            }
        }
    }
    static public ArrayList<String> wordbreakii(String s, ArrayList<String> dict)
    {
        ArrayList<String> result = new ArrayList<>();
        if(s == null || s.length() == 0 || dict.isEmpty())
            return result;
        wordBreakIIUtil(s,dict, result,"");
        return result;
    }
    public static void main(String args[])
    {
        String s = "catsanddog";
        ArrayList<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> result = new ArrayList<>();
        result = wordbreakii(s,dict);
        for(String str : result)
        {
            System.out.println(str);
        }
    }
}
