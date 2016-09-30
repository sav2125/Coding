/**
 * Created by siddharthvarshney on 9/8/16.
 */
public class ZigZagConversion {
    static String convert(String str, int rows)
    {
        if(rows == 1)
            return str;
        String [] answer = new String[rows];
        boolean up = false;
        boolean down = true;
        int rowIndex = 0;
        for(int index = 0; index < str.length();index++)
        {
            if(down == true)
            {
                answer[rowIndex] = answer[rowIndex] + str.charAt(index);
                rowIndex = rowIndex + 1;
                if(rowIndex == rows - 1)
                {
                    rowIndex = 0;
                    up = true;
                    down = false;
                }
            }
            else if(up == true)
            {
                answer[rowIndex] = answer[rowIndex] + str.charAt(index);
                up = false;
                down = true;
            }
        }
        String answerFinal = "";
        for(int i = 0 ;i < rows ; i++)
        {
            System.out.print(answer[i]);
            answerFinal = answerFinal + answer[i];
        }
        return answerFinal;
    }
    public static void main(String args[])
    {
        String str = "PAHNAPLSIIGYIR";
        System.out.println(convert(str,3));
    }
}
