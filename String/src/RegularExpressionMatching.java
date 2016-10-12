/**
 * Created by siddharthvarshney on 10/1/16.
 */
public class RegularExpressionMatching {
    static boolean isMatch(String s, String p)
    {
        if(p.length() == 0)
            return s.length() == 0;
        if(p.length() == 1)
        {
            if(s.length() == 0)
                return false;
            else if( (p.charAt(0) != s.charAt(0)) && p.charAt(0) != '.')
                return false;
            else
                return isMatch(s.substring(1),p.substring(1));
        }
        if(p.charAt(1) != '*')
        {
            if(s.length() == 0)
                return false;
            if((p.charAt(0) != s.charAt(0)) && p.charAt(0) != '.')
                return false;
            else return isMatch(s.substring(1),p.substring(1));
        }
        else
        {
            if(isMatch(s,p.substring(2)))
                return true;
            //case 2.2: a char & '*' can stand for 1 or more preceding element,
            //so try every sub string
            int i = 0;
            while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
    public static void main(String args[])
    {
        //String s = "abb";
        //String p = "c*abb";
        String s = "ccccabb";
        String p = "c*abb";
        System.out.println(isMatch(s,p));
    }
}
