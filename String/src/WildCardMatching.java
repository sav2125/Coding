/**
 * Created by siddharthvarshney on 10/1/16.
 *
 *

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false

 */
public class WildCardMatching {
    static boolean isMatchRecursive(String str,String pat,int i, int j)
    {
        if(i == str.length() && j == pat.length())
            return true;
        if(j == pat.length())
            return i == str.length();
        if(str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?')
            return isMatchRecursive(str,pat,i+1,j+1);
        return true;
    }
    public static void main(String args[])
    {
        String str = "aab";
        String pat = "c*a*b";
        System.out.print(isMatchRecursive(str, pat, 0, 0));
    }
}
