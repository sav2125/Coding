import java.util.HashMap;
/**
 * Created by siddharthvarshney on 10/9/16.
 */
public class RomanToInteger {
    public static void main(String args[])
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = 0;
        String s = "CDXXIV";
        int len = s.length();
        for(int i = 0; i < len; i++)
        {
            if(i <= len - 2 && (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))))
            {
                res = res - map.get(s.charAt(i));
            }
            else
            {
                res = res + map.get(s.charAt(i));
            }
        }
        System.out.println(res);
    }
}
