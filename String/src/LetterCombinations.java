import java.util.HashMap;

/**
 * Created by siddharthvarshney on 9/8/16.
 */
public class LetterCombinations {
    void appendDigits(HashMap<Character,String> hash,String digits, int index, char [] str)
    {
        if(index == digits.length())
        {
            System.out.println(new String(str));
            return;
        }
        String letters = hash.get(digits.charAt(index));
        for(int i = 0; i < letters.length(); i++)
        {
            str[index] = letters.charAt(i);
            appendDigits(hash,digits,index + 1, str);
        }
    }
    public static void main(String args[])
    {
        HashMap<Character,String> hash = new HashMap<Character,String>();
        hash.put('1',"1");
        hash.put('0',"0");
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        String digits = "23";
        char [] str = new char[digits.length()];
        LetterCombinations obj = new LetterCombinations();
        obj.appendDigits(hash,digits , 0, str);
    }
}
