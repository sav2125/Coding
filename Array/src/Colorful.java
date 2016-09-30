import java.util.HashMap;

/**
 * Created by siddharthvarshney on 9/20/16.
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 */
public class Colorful {
    public static void main(String args[])
    {
        int num = 22;
        String test = String.valueOf(num);
        StringBuilder str = new StringBuilder(test);
        HashMap<Integer, Integer> hash = new HashMap<>();
        int flag = 1;
        int tmpint = 0;
        for(int i = 0; i < str.length(); i++)
        {
            String temp = "";
            temp = temp + str.charAt(i);
            for(int j = i; j < str.length(); j++)
            {
                if( i == j)
                {
                    int tmp = Integer.parseInt(temp);
                    if(hash.get(tmp) != null)
                    {
                        flag = 0;
                        break;
                    }
                    else
                    {
                        tmp = Integer.parseInt(temp);
                        tmpint =tmp;
                        hash.put(tmp,1);
                    }
                }
                else
                {
                    int newCharInt = Integer.parseInt(str.substring(j,j+1));
                    temp = temp + str.charAt(j);
                    if(hash.get(tmpint * newCharInt) != null)
                    {
                        flag = 0;
                        break;
                    }
                    else
                    {
                        hash.put(tmpint * newCharInt, 1);
                        tmpint = tmpint * newCharInt;
                    }
                }
            }
            if(flag == 0)
                break;
        }
        if(flag == 1)
            System.out.println("colorful");
        else
            System.out.println("not colorful");

    }
}
