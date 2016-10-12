import java.util.HashMap;

/**
 * Created by siddharthvarshney on 10/9/16.
 */
public class IntegerToRoman {
    public static void main(String args[])
    {
        String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder sb = new StringBuilder();
        int num = 424;
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                sb.append(str[i]);
            }
        }
        System.out.print(sb.toString());
    }
}
