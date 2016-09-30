/**
 * Created by siddharthvarshney on 9/18/16.
 */
public class Atoi {
    public static void main(String args[])
    {
        String str = "   12sd  ";
        String test = str.trim();
        System.out.println(test);
        int index = 0;
        int flag = 1;
        if(test.length() == 0)
            System.out.print("result is 0");
        if(str.charAt(index) == '+')
        {
            flag = 1;
            index = index + 1;
        }
        else if(str.charAt(index) == '-')
        {
            flag = 0;
            index = index + 1;
        }
        int result = 0;
        int len = test.length();
            while(index < len && test.charAt(index) >= '0' && test.charAt(index) <= '9')
            {
                result = (result * 10) + test.charAt(index) - '0';
                System.out.print("result right now is : " + result);
                index++;
            }

        System.out.println("result is : " + result);
    }
}
